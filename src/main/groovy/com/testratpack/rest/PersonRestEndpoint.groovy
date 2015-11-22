package com.testratpack.rest

import ratpack.groovy.handling.GroovyChainAction

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






            }

        }

        all {

            byMethod {

                get {

                }



            }

        }

    }
}
