package biblioteca;

import conexao.ConexaoSQL;
import entidade.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivroBiblioteca {
    //CRUD = C - CREATE

    public void CreateLivro(Livro livro) {
        String sql = "INSERT INTO livros(titulo, autor, ano_publicacao) VALUES(?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConexaoSQL.createConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setInt(3, livro.getAno_publicacao());

            preparedStatement.execute();

            System.out.println("Livro salvo com sucesso");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<Livro> showLivros() {
        String sql = "SELECT * FROM livros";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        List<Livro> livros = new ArrayList<Livro>();
        //classe que vai recuperar os dados do banco.
        ResultSet resultSet = null;

        try {
            connection = ConexaoSQL.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId_livro(resultSet.getInt("id_livro"));
                livro.setTitulo(resultSet.getString("titulo"));
                livro.setAutor(resultSet.getNString("autor"));
                livro.setAno_publicacao(resultSet.getInt("ano_publicacao"));
                livros.add(livro);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }


        return livros;

    }

    public void UpdateLivro(Livro livro) {

        String sql = "UPDATE livros SET titulo = ?, autor = ?, ano_publicacao= ? WHERE id_livro = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConexaoSQL.createConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setInt(3, livro.getAno_publicacao());
            preparedStatement.setInt(4, livro.getId_livro());

            preparedStatement.execute();

            System.out.println("Livro atualizado com sucesso");


        } catch (Exception exception) {

            exception.printStackTrace();
        }


    }

    public void DeleteLivro(int id) {

        String sql = "DELETE FROM livros  WHERE id_livro = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConexaoSQL.createConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            preparedStatement.execute();

            System.out.println("Livro deletado com sucesso");


        } catch (Exception exception) {

           exception.printStackTrace();

        }


    }


}
