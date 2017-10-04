package br.com.gastronomia.model;

public class IngredienteAtributoPK
        private Item item;
        private Product product;

        @ManyToOne
        public Item getItem() {
            return item;
        }

        publicvoid setItem(Item item) {
            this.item = item;
        }

        @ManyToOne
        public Product getProduct() {
            return product;
        }

        publicvoid setProduct(Product product) {
            this.product = product;
        }

        publicboolean equals(Object o) {
            if (this== o) returntrue;
            if (o ==null|| getClass() != o.getClass()) returnfalse;

            ProductItemPk that = (ProductItemPk) o;

            if (item !=null?!item.equals(that.item) : that.item !=null) returnfalse;
            if (product !=null?!product.equals(that.product) : that.product !=null)
                returnfalse;

            returntrue;
        }