package com.dh.clinica.demo.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class DataLoader implements ApplicationRunner {
    private final Logger logger = Logger.getLogger(DataLoader.class);

    private final ConfiguracionH2 configuracionH2;
    @Autowired
    public DataLoader(ConfiguracionH2 configuracionH2) {
        this.configuracionH2 = configuracionH2;
    }

    public void run(ApplicationArguments args) throws SQLException {
logger.info("Insertando roles");
        configuracionH2.executeSQL(
                "INSERT INTO ROLES (id, name) values (1, 'ADMIN')"
        );

        configuracionH2.executeSQL(
                "INSERT INTO ROLES (id, name) values (2, 'USER')"
        );

        logger.info("Insertando usuarios");
        configuracionH2.executeSQL(
                "INSERT INTO USUARIO (id, dni, username, email, password) values (1, 123456789, 'admin', 'admin@gmail.com', '$2a$10$IRd35m1PzgsaucHQ7R12VepL6RlSY3pr.GbKey2GJFAhEvFVDq.qK')" //Para evitar escribir texto plano que pueda tornar vulnerable el acceso.
        );

        configuracionH2.executeSQL(
                "INSERT INTO USUARIO (id, dni, username, email, password) values (2, 123456790, 'user', 'user@gmail.com', '$2a$10$RLEHRpIvs/rFW/3L91tSHOmIKle0nPRoHoa4aCNacF6kaehvESBxO')" //Para evitar escribir texto plano que pueda tornar vulnerable el acceso.
        );

        logger.info("Vinculando roles/usuarios");
        configuracionH2.executeSQL(
                "INSERT INTO USUARIO_ROLES (id_usuario, id_rol) values (1, 1)"
        );
        configuracionH2.executeSQL(
                "INSERT INTO USUARIO_ROLES (id_usuario, id_rol) values (1, 2)"
        );
        configuracionH2.executeSQL(
                "INSERT INTO USUARIO_ROLES (id_usuario, id_rol) values (2, 2)"
        );

        configuracionH2.cerrarConexion();
    }
}
