import com.testratpack.domain.Person
import ratpack.groovy.template.MarkupTemplateModule
import ratpack.jackson.Jackson

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
    module MarkupTemplateModule

  }

  handlers {
    get {
      render groovyMarkupTemplate("index.gtpl", title: "My Ratpack App")
    }

    //TODO this is more for views
    prefix('person'){

    }

    //TODO for login page
    prefix('login'){

    }

    //TODO for admin page
    prefix('admin'){

    }

    prefix('api/person'){

      get {
        //TODO get a list of person from the database
        def person = new Person(name: 'kevin', email: 'kevin@kevin.com', address2: 'asldasldjsakldasj', address1: 'aklsdjlsakdjlaskd', city: 'aklsdklsajdksa', state: 'asdsadd', country: 'kasjdklsjdklad')
        render Jackson.json(person)
      }

      post('create'){
        render 'Create person'
      }

      delete('delete/:id'){

      }

      put('update/:id'){
        def id = pathTokens['id']

      }
    }

    files { dir "public" }
  }
}
