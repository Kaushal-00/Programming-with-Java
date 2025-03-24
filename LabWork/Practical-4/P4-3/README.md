## Practical-4.3:

- Declare an interface called Property containing a method computePrice to compute and return the price.

- The interface is to be implemented by following two classes:
    - Bungalow
    - Flat

- Both the classes have following data members
    - name
    - constructionArea

- The class Bungalow has an additional data member called landArea. 
- Define computePrice for both classes for computing total price. 

- Use following rules for computing total price by summing up sub-costs:

    - Construction cost(for both classes):Rs.500/- per sq.feet
    - Additional cost 
        - For Flat : Rs. 200000/-
        - For Bungalow: Rs. 200/- per sq.
    - feet for landArea
    - Land cost ( only for Bungalow ): Rs. 400/- per sq. feet

- Define method main to show usage of method computePrice.