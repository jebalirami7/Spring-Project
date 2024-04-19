// package project.server.Services;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import project.server.Entities.UserCourse;
// import project.server.Repositories.CertificatRepo;

// @Service
// public class CertificatService {

//     @Autowired
//     private CertificatRepo repo;

//     public UserCourse findById(int id) {
//         Optional<UserCourse> certif = repo.findById(id);
//         if (certif.isPresent())
//             return certif.get();
//         return null;
//     }

//     public UserCourse createCertificat(UserCourse certif) {
//         return repo.save(certif);
//     }

// }
