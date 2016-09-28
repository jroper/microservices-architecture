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

<div>
    <div>
![9](assets/img9.png)
    </div>
    <div class="fragment">
![10](assets/img10.png)
    </div>
    <div class="fragment">
![11](assets/img11.png)
    </div>
</div>
