package dao;


public class DaoFactory {


    static DaoFactory instance;
    private  String url;
    private String username;
    private String password;
    private String Driver;


    private DaoFactory(String url,String username,String password){
        this.url=url;
        this.username=username;
        this.password=password;
    }
}
