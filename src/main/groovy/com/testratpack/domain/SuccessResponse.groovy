package com.testratpack.domain

import groovy.transform.Immutable
import groovy.transform.ToString

/**
 * Created by kevintan on 26/11/2015.
 */
@ToString
@Immutable
class SuccessResponse {
    String message
    Person person
}
