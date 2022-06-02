package com.capstone_seeder.seeding;


import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.FileReader;

public class DataSeeder {
   private static EntityManagerFactory factory;

   public static void seedData() throws Exception {
       factory = Persistence.createEntityManagerFactory("topRatedMovies-persistenceUnit");
       seedMovies();

   }
    private static void seedMovies() throws Exception {
       EntityManager entityManager = factory.createEntityManager();

       entityManager.getTransaction().begin();
       try (BufferedReader br = new BufferedReader(new FileReader("seed_data/Movie.txt"))){
           String line;
           while ((line = br.readLine()) != null) {
               String[] columnValues = line.split("\\|");
               int id = Integer.parseInt(columnValues[0]);
               String overview = columnValues[1];
               String title = columnValues[2];
               String posterPath = columnValues[3];
               String backdropPath = columnValues[4];
               String releaseDate = columnValues[5];

               try {
                   Movie movie = new Movie();
                   movie.setId(id);
                   movie.setOverview(overview);
                   movie.setTitle(title);
                   movie.setPosterPath(posterPath);
                   movie.setBackdropPath(backdropPath);
                   movie.setReleaseDate(releaseDate);

                   entityManager.persist(movie);
               } catch (HibernateException e){
                   e.printStackTrace();
               }
           }
       }
       entityManager.getTransaction().commit();
    }

    }
