package com.testratpack.domain

import groovy.transform.CompileStatic
import groovy.transform.Immutable
import groovy.transform.ToString

/**
 * Created by kevintan on 22/11/2015.
 */
@ToString
@Immutable
@CompileStatic
class Person {

    String name
    String email
    String address1
    String address2
    String city
    String state
    String country

}
