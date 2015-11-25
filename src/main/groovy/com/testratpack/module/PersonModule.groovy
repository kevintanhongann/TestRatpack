package com.testratpack.module

import com.google.inject.AbstractModule
import com.google.inject.Scopes
import com.testratpack.renderer.PersonRenderer
import com.testratpack.rest.PersonRestEndpoint
import com.testratpack.service.PersonService

/**
 * Created by kevintan on 25/11/2015.
 * this class is for dependency injection, it's sort of like dagger 2
 */
class PersonModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(PersonService.class).in(Scopes.SINGLETON)
        bind(PersonRenderer.class).in(Scopes.SINGLETON)
        bind(PersonRestEndpoint.class).in(Scopes.SINGLETON)
    }
}
