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

## Lagom auction

- Ebay clone                                    <!-- .element: class="fragment" -->
- Was a monolith, converted to microservices    <!-- .element: class="fragment" -->
- Will one day overtake Ebay                    <!-- .element: class="fragment" -->

#VSLIDE

## Monolith architecture

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

#VSLIDE

## Synchronous communication

#VSLIDE

### synchronous *adjective* - existing or occurring at the same time.

#VSLIDE

## Synchronous communication

- Typically request/response                    <!-- .element: class="fragment" -->
    - e.g. REST                                 <!-- .element: class="fragment" -->
- Both systems must responsive at the same time <!-- .element: class="fragment" -->

#VSLIDE

<div class="image-fragments">
    <div>
![5](assets/img6.png)
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
</div>

#VSLIDE

## Inconsistency from failure

- Synchronous "at same time" communication of updates is dangerous  <!-- .element: class="fragment" -->
    - Transactions can't span service boundaries                    <!-- .element: class="fragment" -->

#VSLIDE

## Pattern 3: Asynchronous messaging

- Does not require both systems to be responsive    <!-- .element: class="fragment" -->
- Perfect if you already persist events             <!-- .element: class="fragment" -->
- Use persistent events a source of messages        <!-- .element: class="fragment" -->

#VSLIDE

<div class="image-fragments">
    <div>
![17](assets/img17.png)
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

