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
            creditId: $(regex("[1-9]+\\d*")),
            firstName: $(regex("[A-Za-z0-9 ]{3,64}")),
            surname: $(regex("[A-Za-z0-9 ]{3,64}")),
            pesel: $(regex("\\d{11}"))
        )
    }

    response {
        status 204
    }
}