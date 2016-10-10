package proyecto;

import sun.net.www.content.text.Generic;

public class UserDao extends Dao {
    public String name, address;
    public int ID;

    public UserDao(int ID, String name,String address ) {
        super();
        this.name=name;
        this.ID=ID;
        this.address=address;
    }


    @Override
    Generic select() {
        return null;
    }

    @Override
    void update() {

    }

    @Override
    void delete() {

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getID() {
        return ID;
    }
}
