package com.testratpack.rest

import com.fasterxml.jackson.databind.JsonNode
import com.testratpack.domain.Person
import ratpack.groovy.handling.GroovyChainAction
import ratpack.jackson.Jackson

import static ratpack.jackson.Jackson.jsonNode

/**
 * Created by kevintan on 22/11/2015.
 *
 * this class allows rest end points to be pluggable at some extent
 */
class PersonRestEndpoint extends GroovyChainAction{

    //TODO needs to inject a service to get data

    @Override
    void execute() throws Exception {
        path(':id'){
            def id = pathTokens['id']
            byMethod {

                get {

                }

                put {

                }

                delete {

                }
            }

        }

        all {

            byMethod {

                get {
                    render Jackson.json(Person.findAll())
                }

                post {
                    //TODO save data into the database
                    parse(jsonNode()).observe().flatMap { input ->
                        def person = new Person(name: input.get("name").asText(), email: input.get("email").asText(), address1: input.get("address1").asText(), state: input.get("state").asText(), country: input.get("country").asText())
                        if(person.save(failOnError:true)){
                        }
                    }
                }
            }

        }

    }
}
