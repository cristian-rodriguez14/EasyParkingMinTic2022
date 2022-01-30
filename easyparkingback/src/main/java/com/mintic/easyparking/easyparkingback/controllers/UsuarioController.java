package com.mintic.easyparking.easyparkingback.controllers;

import com.mintic.easyparking.easyparkingback.models.requests.UsuarioDetailsRequestModel;
import com.mintic.easyparking.easyparkingback.models.requests.AccesoDetailsRequestModel;
import com.mintic.easyparking.easyparkingback.models.requests.UsuarioChangePassRequestModel;
import com.mintic.easyparking.easyparkingback.models.responses.AccesoRest;
import com.mintic.easyparking.easyparkingback.models.responses.RolRest;
import com.mintic.easyparking.easyparkingback.models.responses.TidentificacionRest;
import com.mintic.easyparking.easyparkingback.models.responses.UsuarioRest;
import com.mintic.easyparking.easyparkingback.services.UsuarioServiceInterface;
import com.mintic.easyparking.easyparkingback.shared.dto.AccesoCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.AccesoDto;
import com.mintic.easyparking.easyparkingback.shared.dto.RolDto;
import com.mintic.easyparking.easyparkingback.shared.dto.TidentificacionDto;
import com.mintic.easyparking.easyparkingback.shared.dto.UsuarioCreationDto;
import com.mintic.easyparking.easyparkingback.shared.dto.UsuarioDto;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import net.bytebuddy.utility.RandomString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private long ultimoUsuarioCreado;
    private String emailUsuario;

    @Autowired
    UsuarioServiceInterface usuarioService;

    @Autowired
    ModelMapper mapper;

    @Autowired
    JavaMailSender mailSender;

    @PostMapping(path = "/newCliente")
    public AccesoRest crearCliente(@RequestBody UsuarioDetailsRequestModel usuarioDetails, AccesoDetailsRequestModel accesoDetails) {
        
        UsuarioCreationDto usuarioCreationDto = mapper.map(usuarioDetails, UsuarioCreationDto.class);
        AccesoCreationDto accesoCreationDto = mapper.map(accesoDetails, AccesoCreationDto.class);
        UsuarioDto createdUsuario = usuarioService.createUsuario(usuarioCreationDto);
        ultimoUsuarioCreado = createdUsuario.getUsuarioId();
        emailUsuario = createdUsuario.getEmailUsuario();
        usuarioService.getIdLastUsuario(ultimoUsuarioCreado);
        AccesoDto createdAcceso = usuarioService.createAccesoCliente(accesoCreationDto);
        mapper.map(createdUsuario, UsuarioRest.class);
        AccesoRest accesoToReturn = mapper.map(createdAcceso, AccesoRest.class);

        return accesoToReturn;
    }

    @PostMapping(path = "/newEmpleado")
    public AccesoRest crearEmpleado(@RequestBody UsuarioDetailsRequestModel usuarioDetails, AccesoDetailsRequestModel accesoDetails) {

        UsuarioCreationDto usuarioCreationDto = mapper.map(usuarioDetails, UsuarioCreationDto.class);
        AccesoCreationDto accesoCreationDto = mapper.map(accesoDetails, AccesoCreationDto.class);

        UsuarioDto createdUsuario = usuarioService.createUsuario(usuarioCreationDto);
        ultimoUsuarioCreado = createdUsuario.getUsuarioId();
        emailUsuario = createdUsuario.getEmailUsuario();
        usuarioService.getIdLastUsuario(ultimoUsuarioCreado);
        AccesoDto createdAcceso = usuarioService.createAccesoEmployee(accesoCreationDto);

        mapper.map(createdUsuario, UsuarioRest.class);
        AccesoRest accesoToReturn = mapper.map(createdAcceso, AccesoRest.class);

        return accesoToReturn;
    }

    @GetMapping(path = "/allUsuarios")
    public List<AccesoRest> datosUsuarios() {
        List<AccesoDto> accesos = usuarioService.getAllUsuarios();

        List<AccesoRest> accesoRests = new ArrayList<>();

        for (AccesoDto acceso : accesos) {
            AccesoRest accesoRest = mapper.map(acceso, AccesoRest.class);
            accesoRests.add(accesoRest);
        }
        return accesoRests;
    }

    @GetMapping
    public AccesoRest getUsuario(String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        AccesoDto usuarioDto = usuarioService.getUsuarioLog(authentication.getPrincipal().toString());

        AccesoRest usuarioToReturn = mapper.map(usuarioDto, AccesoRest.class);

        return usuarioToReturn;
    }

    @GetMapping(path = "/allTiposi")
    public List<TidentificacionRest> tablaTiposi() {
        List<TidentificacionDto> tiposi = usuarioService.getAllTiposi();

        List<TidentificacionRest> tipoiRests = new ArrayList<>();

        for (TidentificacionDto tipoi : tiposi) {
            TidentificacionRest tipoiRest = mapper.map(tipoi, TidentificacionRest.class);
            tipoiRests.add(tipoiRest);
        }
        return tipoiRests;
    }

    @GetMapping(path = "/allRoles")
    public List<RolRest> tablaRoles() {
        List<RolDto> roles = usuarioService.getAllRoles();

        List<RolRest> rolRests = new ArrayList<>();

        for (RolDto rol : roles) {
            RolRest rolRest = mapper.map(rol, RolRest.class);
            rolRests.add(rolRest);
        }
        return rolRests;
    }

    @PutMapping(path = "/{id}")
    public UsuarioRest actualizarInfoUsuario(@RequestBody @Valid UsuarioDetailsRequestModel usuarioCreateRequestModel,
            @PathVariable long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        AccesoDto usuario = usuarioService.getUsuarioLog(authentication.getPrincipal().toString());

        UsuarioCreationDto usuarioUpdateDto = mapper.map(usuarioCreateRequestModel, UsuarioCreationDto.class);

        UsuarioDto usuarioDto = usuarioService.updateUsuario(id, usuario.getIdUsuario().getIdTipoi().getTipoiId(), usuarioUpdateDto);

        UsuarioRest updatedUsuario = mapper.map(usuarioDto, UsuarioRest.class);

        return updatedUsuario;
    }

    @PutMapping(path = "/delete/{id}")
    public AccesoRest borrarEmpleado(@PathVariable long id) {

        AccesoDto accesoDto = usuarioService.deleteEmpleado(id);

        AccesoRest updatedAcceso = mapper.map(accesoDto, AccesoRest.class);

        return updatedAcceso;
    }

    @PutMapping(path = "/suscripcion/{id}")
    public AccesoRest realizarSuscripcion(@RequestBody @Valid AccesoDetailsRequestModel accesoCreateRequestModel,
            @PathVariable long id) {
        System.out.println("1: "+accesoCreateRequestModel.getExpira());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        usuarioService.getUsuarioLog(authentication.getPrincipal().toString());

        AccesoCreationDto accesoUpdateDto = mapper.map(accesoCreateRequestModel, AccesoCreationDto.class);
        
        AccesoDto accesoDto = usuarioService.makeSuscription(id, accesoUpdateDto);
        
        AccesoRest updatedAcceso = mapper.map(accesoDto, AccesoRest.class);

//        if (updatedAcceso.getExpira().compareTo(new Date(System.currentTimeMillis())) < 0) {
//            AccesoDto accesoDt = usuarioService.inicializarVariables(id, accesoUpdateDto);
//            mapper.map(accesoDt, AccesoRest.class);
//        }

        return updatedAcceso;
    }

    @PostMapping("/forgot_password")
    public AccesoRest processForgotPassword(@RequestBody @Valid UsuarioChangePassRequestModel usuarioChangePassRequestModel) {
        AccesoDto accesoDto = usuarioService.getAccesoUsuario(usuarioChangePassRequestModel.getEmail());
        AccesoRest usuarioFind = mapper.map(accesoDto, AccesoRest.class);
        String email = usuarioFind.getIdUsuario().getEmailUsuario();
        String token = RandomString.make(30);

        try {
            usuarioService.updateResetPasswordToken(token, email);
//            String resetPasswordLink = "http://localhost:8080/usuario" + "/reset_password?token=" + token;
            String resetPasswordLink = "http://localhost:3000" + "/reset_password/" + token;
            sendEmail(email, resetPasswordLink);

        } catch (UsernameNotFoundException ex) {
            System.out.println("error"+ ex.getMessage());
        } catch (UnsupportedEncodingException | MessagingException e) {
            System.out.println("error"+ "Error while sending email");
        }
        
        return usuarioFind;
    }

    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("pligurta465@gmail.com", "Soporte Easy Parking");
        helper.setTo(recipientEmail);

        String subject = "Aquí esta el link para modificar su contraseña";

        String content = "<p>Hola,</p>"
                + "<p>Usted solicitó cambiar su contraseña.</p>"
                + "<p>Click en el link de abajo para cambiar su contraseña:</p>"
                + "<p><a href=\"" + link + "\">Cambiar mi contraseña</a></p>"
                + "<br>"
                + "<p>Ignore este correo si usted recuerda su contraseña, "
                + "o no hizó esta solicitud.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

    @PutMapping("/reset_password/{token}")
    public AccesoRest processResetPassword(@RequestBody @Valid AccesoDetailsRequestModel accesoCreateRequestModel,
            @PathVariable String token) throws MessagingException, UnsupportedEncodingException{
        System.out.println("Usted esta aqui");
        AccesoCreationDto accesoUpdateDto = mapper.map(accesoCreateRequestModel, AccesoCreationDto.class);

        AccesoDto accesoDto = usuarioService.updatePassword(token, accesoUpdateDto);

        AccesoRest updatedAcceso = mapper.map(accesoDto, AccesoRest.class);
        sendEmailData(accesoDto);
        return updatedAcceso;
    }
    
    public void sendEmailData(AccesoDto accesoDto)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("pligurta465@gmail.com", "Soporte Easy Parking");
        helper.setTo(accesoDto.getIdUsuario().getEmailUsuario());

        String subject = "Confirmar datos inicio de sesión";

        String content = "<p>Muchas gracias por preferirnos,</p>"
                + "<p>Usted ha cambiado su contraseña de forma exitosa.</p>"
                + "<p>No se le olvide que los datos para iniciar sesion son:</p>"
                + "<p>Usuario: \"" + accesoDto.getUsername() + "\"</p>"
                + "<br>"
                + "<p>Y la contraseña es la que usted módificó</p>"
                + "<p>Esperamos que sea de su agrado, Bienvenido a Easy Parking</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }
    
}
