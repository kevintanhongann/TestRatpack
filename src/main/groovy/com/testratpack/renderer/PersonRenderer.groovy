package com.testratpack.renderer

import com.testratpack.domain.Person
import ratpack.groovy.Groovy
import ratpack.groovy.handling.GroovyContext
import ratpack.groovy.render.GroovyRendererSupport
import ratpack.jackson.Jackson

import static ratpack.jackson.Jackson.json

/**
 * Created by kevintan on 25/11/2015.
 */
/**
 * Treat this as a custom json marshaller for grails, but in a ratpack way
 */
class PersonRenderer extends GroovyRendererSupport<Person>{

    @Override
    void render(GroovyContext context, Person person) throws Exception {
        context.byContent {
            json{
                context.render json(person)
            }


            xml {
                context.render Groovy.markupBuilder("application/xml", "UTF-8"){
                    delegate.person(id: person.id){
                        name person.name
                        email person.email
                        city person.city
                        state person.state
                        country person.country
                        address1 person.address1
                        address2 person.address2
                    }
                }
            }
        }
    }
}
