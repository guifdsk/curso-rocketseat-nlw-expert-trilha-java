package io.github.guifdsk.certificationnlw.seed;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateSeed {

    private final JdbcTemplate jdbcTemplate;

    public CreateSeed(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5434/pg_nlw");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");

        CreateSeed createSeed = new CreateSeed(dataSource);
        createSeed.run(args);
    }

    public void run(String... args){
        executeSqlFile("src/main/resources/create.sql");
    }

    private void executeSqlFile(String file) {
        try{
            String sqlScrript = new String(Files.readAllBytes(Paths.get(file)));

            jdbcTemplate.execute(sqlScrript);

            System.out.println("Seed realizado com sucesso");
        }
        catch (IOException e){
            System.err.println("Erro ao executar arquivo" + e.getMessage());
        }
    }
}
