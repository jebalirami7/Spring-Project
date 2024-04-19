// package project.server.Controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;
// import project.server.Entities.UserCourse;
// import project.server.Services.CertificatService;

// @RestController
// @RequestMapping(path = "/certificat")
// public class CertificatController {

//     @Autowired
//     private CertificatService service;

//     @PostMapping
//     UserCourse createCerfificat(@RequestBody UserCourse certif) {
//         return service.createCertificat(certif);
//     }

//     @GetMapping(path = "/{id}")
//     UserCourse getCertificat(@PathVariable("id") int id) {
//         return service.findById(id);
//     }

// }
