package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Creates new customer")

    request {
        method POST()
        url '/customer'
        headers {
            contentType(applicationJson())
        }
        body(
            creditId: 3,
            firstName: "Alfa",
            surname: "Romeo",
            pesel: "11335577990"
        )
    }

    response {
        status 204
    }
}