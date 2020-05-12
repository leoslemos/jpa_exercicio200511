package br.senai.sc.dao;

import br.senai.sc.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("jpa_exercico200511");
        entityManager = factory.createEntityManager();

        criarUsuario();

        entityManager.close();
        factory.close();
    }

    public static void criarUsuario(){

        try{
            entityManager.getTransaction().begin();

            Usuario usuario = new Usuario();
            usuario.setNome("Rolando Escadabaixo");
            usuario.setEmail("reb123@gmail.com");
            usuario.setSenha("1q2w3e4r");

            entityManager.persist(usuario);
            entityManager.getTransaction().commit();

            System.out.println("Usuario cadastrado com sucesso: " + usuario.getNome());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
            System.out.println("E-mail já cadastrado!");
        }
    }
}
