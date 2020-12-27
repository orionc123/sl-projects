package com.hcl.utility;

import javax.persistence.*;

public class HibernateUtility {
    private static final EntityManagerFactory entityManagerFactory;

    static{
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }
}
