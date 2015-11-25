import com.testratpack.domain.Person
import com.testratpack.module.PersonModule
import com.testratpack.rest.PersonRestEndpoint
import com.testratpack.service.PersonService
import com.zaxxer.hikari.HikariConfig
import ratpack.groovy.sql.SqlModule
import ratpack.groovy.template.MarkupTemplateModule
import ratpack.hikari.HikariModule
import ratpack.jackson.Jackson

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
    bindings {
        module MarkupTemplateModule
        module SqlModule

        //inject person module
        module PersonModule

        //configure hikari connection pooling
        module HikariModule, { HikariConfig c ->
            c.addDataSourceProperty("URL", "jdbc:h2:mem:dev;INIT=CREATE SCHEMA IF NOT EXISTS DEV")
            c.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource")
        }
    }

    handlers {
        get {
            render groovyMarkupTemplate("index.gtpl", title: "My Ratpack App")
        }

        //TODO this is more for views
        prefix('person') {
            //TODO shows a list of person in a table view in a gtpl
        }

        //TODO for login page
        prefix('login') {

        }

        //TODO for admin page
        prefix('admin') {

        }

        prefix('api/person') {
            //this plugs the rest end point implementation, you can swap to another implementation if you want to
            all chain(registry.get(PersonRestEndpoint))
        }

        files { dir "public" }
    }
}
