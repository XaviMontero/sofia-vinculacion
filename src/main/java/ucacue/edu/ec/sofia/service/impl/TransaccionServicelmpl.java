package ucacue.edu.ec.sofia.service.impl;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.sofia.common.util.DateUtils;
import ucacue.edu.ec.sofia.dto.TransacionDTO;
import ucacue.edu.ec.sofia.persistence.entity.Transacion;
import ucacue.edu.ec.sofia.persistence.repository.TransacionRepository;

import java.io.File;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service("transaccionServicelmpl")
public class TransaccionServicelmpl extends   GenericCRUDServiceImpl <Transacion, TransacionDTO> {

    @Autowired
    TransacionRepository repository;
    @Autowired
    CuentaServicelmpl cuentaServicelmpl;
    @Autowired
    TrabajoServicelmpl trabajoServicelmpl;
    @Autowired
    TipoTransaccionServicelmpl transaccionServicelmpl;
    @Override
    public Transacion getOne(TransacionDTO transacionDTO) {
        return repository.getOneByCuentaId(transacionDTO.getCuentaDTO().getId());
    }

    @Override
    public Transacion findByCedula(TransacionDTO domainObject) {
        return null;
    }

    @Override
    public Transacion mapTo(TransacionDTO transacionDTO) {
        Transacion transacion = new Transacion();

        if (transacionDTO.getCuentaDTO().getId() != 1){
            transacion.setCuenta(cuentaServicelmpl.getOne(transacionDTO.getCuentaDTO()));
        }else {
            transacion.setCuenta(cuentaServicelmpl.findByCedula(transacionDTO.getCuentaDTO()));

        }

        transacion.setEstado_empresa(1);
        transacion.setTrabajador(trabajoServicelmpl.getOne(transacionDTO.getTrabajadorDTO()));
        transacion.setFecha(DateUtils.getFechaFromStringddMMyyyy(DateUtils.getFechaActual()));
        transacion.setTipoTransacion(transaccionServicelmpl.getOne(transacionDTO.getTipoTransacionDTO()));
        if(transacionDTO.getTipoTransacionDTO().getDescripcion().equals("Depositos")){
            transacion.setMonto(transacionDTO.getMonto());
        }else   if(transacionDTO.getTipoTransacionDTO().getDescripcion().equals("Retiros")){
            transacion.setMonto(-transacionDTO.getMonto());
        }else   if(transacionDTO.getTipoTransacionDTO().getDescripcion().equals("Interes")){
            transacion.setMonto(transacionDTO.getMonto());
        }
        return transacion;
    }

    @Override
    public TransacionDTO build(Transacion transacion) {
        TransacionDTO transacionDTO = new TransacionDTO();
        transacionDTO.setCuentaDTO(cuentaServicelmpl.build(transacion.getCuenta()));
        transacionDTO.setEstado_empresa(transacion.getEstado_empresa());
        transacionDTO.setFecha(DateUtils.convertirGreggorianToDDMMYYYY(transacion.getFecha().toString()));
        transacionDTO.setTipoTransacionDTO(transaccionServicelmpl.build(transacion.getTipoTransacion()));
        transacionDTO.setTrabajadorDTO(trabajoServicelmpl.build(transacion.getTrabajador()));
        transacionDTO.setMonto(transacion.getMonto());
        return transacionDTO;
    }
    @Override
    public byte[] generarReporte(Integer idCuenta){
        byte[] data = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:postgresql://dbpostgresql-db/sofia-db1","postgres", "XaviNoob2016");
            conn.setAutoCommit(false);

            File file = new ClassPathResource("/reports/libreta.jasper").getFile();
            HashMap<String,Object> parametros = new  HashMap<String,Object>();
            parametros.put("cuenta",idCuenta);
            JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros, conn);
            data = JasperExportManager.exportReportToPdf(print);
            repository.updateEstado(idCuenta);

        }
        catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            System.exit(4);
        }   catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(   e.toString());
        } catch (JRException e) {
            System.out.println(   e.toString());
            e.printStackTrace();
        }
        return  data;
    }
    @Override
    public Optional<Transacion> findExisting(TransacionDTO domainObject) {
        return Optional.empty();
    }

    @Override
    public List<TransacionDTO> findAll() {
    return  null;

    }

}
