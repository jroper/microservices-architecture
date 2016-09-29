#HSLIDE

## Monolith to reactive

*It's all about architecture*

James Roper

`@jroper`

Lightbend

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

#VSLIDE

<div class="image-fragments">
    <div>
![0](assets/img0.png)
    </div>
    <div class="fragment">
![1](assets/img1.png)
    </div>
    <div class="fragment">
![2](assets/img2.png)
    </div>
    <div class="fragment">
![3](assets/img3.png)
    </div>
    <div class="fragment">
![4](assets/img4.png)
    </div>
    <div class="fragment">
![5](assets/img5.png)
    </div>
</div>

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

#VSLIDE

<div class="image-fragments">
    <div>
![5](assets/img5.png)
    </div>
    <div class="fragment">
![6](assets/img6.png)
    </div>
    <div class="fragment">
![7](assets/img7.png)
    </div>
    <div class="fragment">
![8](assets/img8.png)
    </div>
</div>

#HSLIDE

## Pattern 1: Circuit breakers

- A gate that opens in the event of failure     <!-- .element: class="fragment" -->
    - Including timeouts                        <!-- .element: class="fragment" -->
- Protects already failing services             <!-- .element: class="fragment" -->
- Allows fail fast handling                     <!-- .element: class="fragment" -->

#VSLIDE

<div class="image-fragments">
    <div>
![9](assets/img9.png)
    </div>
    <div class="fragment">
![10](assets/img10.png)
    </div>
    <div class="fragment">
![11](assets/img11.png)
    </div>
    <div class="fragment">
![12](assets/img12.png)
    </div>
</div>

#HSLIDE

## Pattern 2: Failure recovery

- Work around failure by degrading                  <!-- .element: class="fragment" -->
- Not every call is necessary to render every page  <!-- .element: class="fragment" -->

#VSLIDE

<div class="image-fragments">
    <div>
![13](assets/img13.png)
    </div>
    <div class="fragment">
![14](assets/img14.png)
    </div>
</div>

#HSLIDE

## Failure can lead to inconsistency

#VSLIDE

<div class="image-fragments">
    <div>
![15](assets/img15.png)
    </div>
    <div class="fragment">
![16](assets/img16.png)
    </div>
    <div class="fragment">
![17](assets/img17.png)
    </div>
    <div class="fragment">
![18](assets/img18.png)
    </div>
    <div class="fragment">
![19](assets/img19.png)
    </div>
    <div class="fragment">
![20](assets/img20.png)
    </div>
    <div class="fragment">
![21](assets/img21.png)
    </div>
    <div class="fragment">
![22](assets/img22.png)
    </div>
    <div class="fragment">
![23](assets/img23.png)
    </div>
</div>

#VSLIDE

## Inconsistency from failure

- Synchronous "at same time" communication of updates is dangerous  <!-- .element: class="fragment" -->
    - Transactions can't span service boundaries                    <!-- .element: class="fragment" -->

#HSLIDE

## Pattern 3: Asynchronous messaging

- Does not require both systems to be responsive    <!-- .element: class="fragment" -->
- Perfect if you already persist events             <!-- .element: class="fragment" -->
- Use persistent events as a source of messages     <!-- .element: class="fragment" -->

#VSLIDE

<div class="image-fragments">
    <div>
![17](assets/img17.png)
    </div>
    <div class="fragment">
![24](assets/img24.png)
    </div>
    <div class="fragment">
![25](assets/img25.png)
    </div>
    <div class="fragment">
![26](assets/img26.png)
    </div>
    <div class="fragment">
![27](assets/img27.png)
    </div>
</div>

#HSLIDE

## Unacceptable degradation

- Earlier we degraded the item page with empty bid history  <!-- .element: class="fragment" -->
- Price was also $0                                         <!-- .element: class="fragment" -->
- Users may tolerate no history, but not wrong price        <!-- .element: class="fragment" -->

#VSLIDE

<div class="image-fragments">
    <div>
![28](assets/img28.png)
    </div>
    <div class="fragment">
![29](assets/img29.png)
    </div>
</div>

#HSLIDE

## Pattern 4: Denormalize

- Push important information to other services      <!-- .element: class="fragment" -->
    - Important for system funcitons                <!-- .element: class="fragment" -->
    - Important for business functions              <!-- .element: class="fragment" -->
- Store duplicated information in those services    <!-- .element: class="fragment" -->
    - AKA denormalization                           <!-- .element: class="fragment" -->

#VSLIDE

<div class="image-fragments">
    <div>
![30](assets/img30.png)
    </div>
    <div class="fragment">
![31](assets/img31.png)
    </div>
    <div class="fragment">
![32](assets/img32.png)
    </div>
</div>

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

http://lagomframework.com
https://github.com/jroper/mircoservices-architecture

