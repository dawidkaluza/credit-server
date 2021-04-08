package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Returns customers with given credit ids")

    request {
        method GET()
        url '/customer?creditIds=1&creditIds=2'
    }

    response {
        status 200
        body("""
        [
            {
                "creditId": 1,
                "firstName": "David",
                "surname": "Davidovsky",
                "pesel": "11223344556"
            },
            {
                "creditId": 2,
                "firstName": "Mark",
                "surname": "Markiee",
                "pesel": "11223344556"
            }
        ]
        """)
        headers {
            contentType(applicationJson())
        }
    }
}