## Monolith to reactive

*It's all about architecture*

<p style="margin-top: 100px; font-weight: bold;">James Roper</p>

<p><tt>@jroper</tt></p>

<img style="width: 30%; margin-top: 50px; border: none; background: none; box-shadow: none;" src="https://d3gnpvjw8j16uq.cloudfront.net/assets/images/svg/logo/09a7a2d971d039288221b17d1ef8ffb3-lightbend-color-reverse.svg" />

#HSLIDE

## Agenda

- Identify pitfalls of monolith conversions     <!-- .element: class="fragment" -->
- Architect reactive solutions                  <!-- .element: class="fragment" -->
- See Lagom in action                           <!-- .element: class="fragment" -->
- Live coding!                                  <!-- .element: class="fragment" -->

#HSLIDE

## Lagom Auction

- ebay clone                                    <!-- .element: class="fragment" -->
- Was a monolith, converted to microservices    <!-- .element: class="fragment" -->
- Will one day overtake ebay!                   <!-- .element: class="fragment" -->

#VSLIDE?image=assets/img0.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img1.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img2.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img3.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img4.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img5.png
<!-- .slide: data-background-transition="none" -->

#HSLIDE

## What if something goes wrong?

- Microservices means more moving parts     <!-- .element: class="fragment" -->
    - More chance for failure               <!-- .element: class="fragment" -->
    - More chance for inconsistency         <!-- .element: class="fragment" -->

#VSLIDE

## Synchronous communication

<span class="fragment">
**synchronous** *adj.* - existing or occurring at the same time.
</span>

#VSLIDE

## Synchronous communication

- Typically request/response                        <!-- .element: class="fragment" -->
    - e.g. REST                                     <!-- .element: class="fragment" -->
- Both systems must be responsive at the same time  <!-- .element: class="fragment" -->

#VSLIDE?image=assets/img5.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img6.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img7.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img8.png
<!-- .slide: data-background-transition="none" -->

#HSLIDE

## Pattern 1: Circuit breakers

- A gate that opens in the event of failure     <!-- .element: class="fragment" -->
    - Including timeouts                        <!-- .element: class="fragment" -->
- Protects already failing services             <!-- .element: class="fragment" -->
- Allows fail fast handling                     <!-- .element: class="fragment" -->

#VSLIDE?image=assets/img9.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img10.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img11.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img12.png
<!-- .slide: data-background-transition="none" -->

#HSLIDE

## Pattern 2: Failure recovery

- Work around failure by degrading                  <!-- .element: class="fragment" -->
- Not every call is necessary to render every page  <!-- .element: class="fragment" -->

#VSLIDE?image=assets/img13.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img14.png
<!-- .slide: data-background-transition="none" -->

#HSLIDE

## Failure can lead to inconsistency

#VSLIDE?image=assets/img15.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img16.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img17.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img18.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img19.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img20.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img21.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img22.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img23.png
<!-- .slide: data-background-transition="none" -->

#VSLIDE

## Inconsistency from failure

- Synchronous "at same time" communication of updates is dangerous  <!-- .element: class="fragment" -->
    - Transactions can't span service boundaries                    <!-- .element: class="fragment" -->

#HSLIDE

## Pattern 3: Asynchronous messaging

- Does not require both systems to be responsive    <!-- .element: class="fragment" -->
- Perfect if you already persist events             <!-- .element: class="fragment" -->
- Use persistent events as a source of messages     <!-- .element: class="fragment" -->

#VSLIDE?image=assets/img17.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img24.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img25.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img26.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img27.png
<!-- .slide: data-background-transition="none" -->

#HSLIDE

## Unacceptable degradation

- Earlier we degraded the item page with empty bid history  <!-- .element: class="fragment" -->
- Price was also $0                                         <!-- .element: class="fragment" -->
- Users may tolerate no history, but not wrong price        <!-- .element: class="fragment" -->

#VSLIDE?image=assets/img28.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img29.png
<!-- .slide: data-background-transition="none" -->

#HSLIDE

## Pattern 4: Denormalize

- Push important information to other services      <!-- .element: class="fragment" -->
    - Important for system funcitons                <!-- .element: class="fragment" -->
    - Important for business functions              <!-- .element: class="fragment" -->
- Store duplicated information in those services    <!-- .element: class="fragment" -->
    - AKA denormalization                           <!-- .element: class="fragment" -->

#VSLIDE?image=assets/img30.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img31.png
<!-- .slide: data-background-transition="none" -->
#VSLIDE?image=assets/img32.png
<!-- .slide: data-background-transition="none" -->

#HSLIDE

## Summary

- Monolith to microservices requires rearchitecting data flows  <!-- .element: class="fragment" -->
- Failure and inconsistency must be managed                     <!-- .element: class="fragment" -->
- Use:                                                          <!-- .element: class="fragment" -->
    - Circuit breakers                                          <!-- .element: class="fragment" -->
    - Failure degradation                                       <!-- .element: class="fragment" -->
    - Asynchronous messaging                                    <!-- .element: class="fragment" -->
    - Denormalization                                           <!-- .element: class="fragment" -->

#VSLIDE

## Next steps

[http://lagomframework.com](http://lagomframework.com)

[https://gitpitch.com/jroper/mircoservices-architecture](https://github.com/jroper/mircoservices-architecture)
