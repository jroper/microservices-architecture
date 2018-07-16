## Monolith to reactive

*It's all about architecture*

<p style="margin-top: 100px; font-weight: bold;">James Roper</p>

<p><tt>@jroper</tt></p>

<img style="width: 30%; margin-top: 50px; border: none; background: none; box-shadow: none;" src="https://d3gnpvjw8j16uq.cloudfront.net/assets/images/svg/logo/09a7a2d971d039288221b17d1ef8ffb3-lightbend-color-reverse.svg" />

---

## Agenda

@ul
- Identify pitfalls of monolith conversions
- Architect reactive solutions
- See Lagom in action
- Live coding!
@ulend

---

## Lagom Auction

@ul
- ebay clone
- Was a monolith, converted to microservices
- Will one day overtake ebay!
@ulend

+++?image=assets/img0.png&transition=none
+++?image=assets/img1.png&transition=none
+++?image=assets/img2.png&transition=none
+++?image=assets/img3.png&transition=none
+++?image=assets/img4.png&transition=none
+++?image=assets/img5.png&transition=none

---

## What if something goes wrong?

@ul
- Microservices means more moving parts
    - More chance for failure
    - More chance for inconsistency
@ulend

+++

## Synchronous communication

@css[fragment](**synchronous** *adj.* - existing or occurring at the same time.)

+++

## Synchronous communication

@ul
- Typically request/response
    - e.g. REST
- Both systems must be responsive at the same time
@ulend

+++?image=assets/img5.png&transition=none
+++?image=assets/img6.png&transition=none
+++?image=assets/img7.png&transition=none
+++?image=assets/img8.png&transition=none

---

## Pattern 1: Circuit breakers

@ul
- A gate that opens in the event of failure
    - Including timeouts
- Protects already failing services
- Allows fail fast handling
@ulend

+++?image=assets/img9.png&transition=none
+++?image=assets/img10.png&transition=none
+++?image=assets/img11.png&transition=none
+++?image=assets/img12.png&transition=none

---

## Pattern 2: Failure recovery

@ul
- Work around failure by degrading
- Not every call is necessary to render every page
@ulend

+++?image=assets/img13.png&transition=none
+++?image=assets/img14.png&transition=none

---

## Failure can lead to inconsistency

+++?image=assets/img15.png&transition=none
+++?image=assets/img16.png&transition=none
+++?image=assets/img17.png&transition=none
+++?image=assets/img18.png&transition=none
+++?image=assets/img19.png&transition=none
+++?image=assets/img20.png&transition=none
+++?image=assets/img21.png&transition=none
+++?image=assets/img22.png&transition=none
+++?image=assets/img23.png&transition=none

+++

## Inconsistency from failure

@ul
- Synchronous "at same time" communication of updates is dangerous
    - Transactions can't span service boundaries
@ulend

---

## Pattern 3: Asynchronous messaging

@ul
- Does not require both systems to be responsive
- Perfect if you already persist events
- Use persistent events as a source of messages
@ulend

+++?image=assets/img17.png&transition=none
+++?image=assets/img24.png&transition=none
+++?image=assets/img25.png&transition=none
+++?image=assets/img26.png&transition=none
+++?image=assets/img27.png&transition=none

---

## Unacceptable degradation

@ul
- Earlier we degraded the item page with empty bid history
- Price was also $0
- Users may tolerate no history, but not wrong price
@ulend

+++?image=assets/img28.png&transition=none
+++?image=assets/img29.png&transition=none

---

## Pattern 4: Denormalize

@ul
- Push important information to other services
    - Important for system funcitons
    - Important for business functions
- Store duplicated information in those services
    - AKA denormalization
@ulend

+++?image=assets/img30.png&transition=none
+++?image=assets/img31.png&transition=none
+++?image=assets/img32.png&transition=none

---

## Summary

@ul
- Monolith to microservices requires rearchitecting data flows
- Failure and inconsistency must be managed
- Use:
    - Circuit breakers
    - Failure degradation
    - Asynchronous messaging
    - Denormalization
@ulend

+++

## Next steps

[http://lagomframework.com](http://lagomframework.com)

[https://gitpitch.com/jroper/mircoservices-architecture](https://github.com/jroper/mircoservices-architecture)
