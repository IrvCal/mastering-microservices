package PracticeWithObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MainProducts {

    private static ArrayList<Product> productList;
    private static ArrayList<Product> additionalProductList;

    public static void main(String[] args) {
        productList = new ArrayList<>(initializeData());
        additionalProductList = new ArrayList<>(initializeData2());
        ;
        //Recollect all items with the same category
// CATEGORIES: FOOD,HEALTHCARE,ELECTRONIC,CLOTHING, BOOKS

        seeDiferentProducts(productList,additionalProductList);

        System.out.println(productList.size());
        System.out.println(additionalProductList.size());
        productList.addAll(additionalProductList);
        System.out.println(productList.size());

        ArrayList<Product> food =  new ArrayList<>(productList.stream().filter(product -> product.getCategory().equals(
                Category.FOOD)).collect(Collectors.toList()));
        ArrayList<Product> healthcare = new ArrayList<>(productList.stream().filter(product -> product.getCategory().equals(
                Category.HEALTHCARE)).collect(Collectors.toList()));
        List<Product> electronic =  new ArrayList<>(productList.stream().filter(product -> product.getCategory().equals(
                Category.ELECTRONIC)).collect(Collectors.toList()));
        List<Product> clothing =  new ArrayList<>(productList.stream().filter(product -> product.getCategory().equals(
                Category.CLOTHING)).collect(Collectors.toList()));
        List<Product> books =  new ArrayList<>(productList.stream().filter(product -> product.getCategory().equals(
                Category.BOOKS)).collect(Collectors.toList()));

    }
    // Aqui puedo tener varios registros iguales pero con diferente UUID
    private static void seeDiferentProducts(ArrayList<Product> productList, ArrayList<Product> additionalProductList) {
//        productList.stream().filter(product -> additionalProductList.stream().map(Product::getName).anyMatch());
    }

    public static List<Product> initializeData2(){
        return List.of(
                new Product(UUID.randomUUID(), "Samsung Galaxy Watch 4", "Smartwatch with health tracking features", Category.ELECTRONIC, 249.99, 50, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "LG 75-inch 8K OLED TV", "Premium OLED TV for an exceptional viewing experience", Category.ELECTRONIC, 2999.99, 30, true, 15.0f, null, 2),
                new Product(UUID.randomUUID(), "Adidas Superstar Sneakers", "Iconic sneakers known for their style", Category.CLOTHING, 79.99, 100, true, 20.0f, null, 3),
                new Product(UUID.randomUUID(), "The Hitchhiker's Guide to the Galaxy by Douglas Adams", "A humorous science fiction classic", Category.BOOKS, 7.99, 200, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Oranges (1 lb)", "Fresh and organic oranges for a vitamin boost", Category.FOOD, 2.49, 800, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Johnson & Johnson Baby Shampoo", "Gentle shampoo for baby's delicate skin", Category.HEALTHCARE, 3.99, 1500, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "Sony PlayStation 5 Pro", "Upgraded gaming console for next-level gaming", Category.ELECTRONIC, 599.99, 40, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Calvin Klein Women's Handbag", "Stylish handbag for fashion-conscious women", Category.CLOTHING, 59.99, 150, true, 20.0f, null, 3),
                new Product(UUID.randomUUID(), "Brave New World by Aldous Huxley", "A dystopian novel exploring a futuristic society", Category.BOOKS, 8.99, 250, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Strawberries (1 lb)", "Fresh and organic strawberries for desserts", Category.FOOD, 4.99, 500, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Tylenol PM Nighttime Pain Reliever", "Pain relief and sleep aid for a restful night", Category.HEALTHCARE, 7.49, 1800, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "Apple MacBook Air 13-inch", "Thin and lightweight laptop for on-the-go productivity", Category.ELECTRONIC, 999.99, 25, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Nike Women's Running Shorts", "Comfortable shorts for women on the move", Category.CLOTHING, 29.99, 120, true, 20.0f, null, 3),
                new Product(UUID.randomUUID(), "The Road by Cormac McCarthy", "A post-apocalyptic novel of survival and hope", Category.BOOKS, 10.49, 350, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Blueberries (1 lb)", "Fresh and organic blueberries for snacking", Category.FOOD, 4.49, 400, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Band-Aid Tough-Strips Bandages", "Durable bandages for tough outdoor activities", Category.HEALTHCARE, 4.99, 2200, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "Sony Noise-Canceling Wireless Earbuds", "Wireless earbuds with noise-canceling technology", Category.ELECTRONIC, 199.99, 70, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Levi's Men's Denim Jacket", "Classic denim jacket for men", Category.CLOTHING, 79.99, 80, true, 20.0f, null, 3),
                new Product(UUID.randomUUID(), "LG 55-inch 4K OLED TV", "Immersive OLED TV for cinematic entertainment", Category.ELECTRONIC, 1599.99, 50, true, 15.0f, null, 2),
                new Product(UUID.randomUUID(), "Adidas Ultraboost Running Shoes", "Premium running shoes for exceptional comfort", Category.CLOTHING, 149.99, 200, true, 20.0f, null, 3),
                new Product(UUID.randomUUID(), "The Great Gatsby by F. Scott Fitzgerald", "A classic novel depicting the Jazz Age", Category.BOOKS, 9.99, 500, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Bananas (1 lb)", "Fresh and organic bananas for a healthy diet", Category.FOOD, 1.99, 1000, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Pfizer COVID-19 Vaccine", "A highly effective COVID-19 vaccine", Category.HEALTHCARE, 0.0, 1000000, true, 100.0f, null, 1),
                new Product(UUID.randomUUID(), "Moby-Dick by Herman Melville", "A novel of obsession and the high seas", Category.BOOKS, 12.99, 180, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Apples (1 lb)", "Fresh and organic apples for a healthy snack", Category.FOOD, 2.99, 600, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Neutrogena Rapid Wrinkle Repair Cream", "Anti-aging skincare for smoother and younger-looking skin", Category.HEALTHCARE, 19.99, 1000, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "Bose SoundLink Portable Speaker", "Portable speaker for music on the go", Category.ELECTRONIC, 129.99, 90, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Adidas Women's Ultraboost Running Shoes", "Premium running shoes designed for women", Category.CLOTHING, 149.99, 130, true, 20.0f, null, 3),
                new Product(UUID.randomUUID(), "Pride and Prejudice by Jane Austen", "A classic novel of love and societal expectations", Category.BOOKS, 6.99, 280, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Spinach (1 lb)", "Fresh and organic spinach for healthy salads", Category.FOOD, 2.29, 400, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Johnson & Johnson Baby Lotion", "Gentle moisturizing lotion for baby's soft skin", Category.HEALTHCARE, 4.49, 800, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "Sony 32-inch HD LED TV", "Compact LED TV with crisp visuals", Category.ELECTRONIC, 499.99, 20, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Calvin Klein Men's Polo Shirt", "Stylish polo shirt for men with a classic look", Category.CLOTHING, 34.99, 160, true, 20.0f, null, 3)
        );
    }
    public static List<Product> initializeData() {
        return List.of(
                new Product(UUID.randomUUID(), "Samsung Galaxy S21", "High-end Android smartphone with a stunning display", Category.ELECTRONIC, 899.99, 100, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "LG 55-inch 4K OLED TV", "Immersive OLED TV for cinematic entertainment", Category.ELECTRONIC, 1599.99, 50, true, 15.0f, null, 2),
                new Product(UUID.randomUUID(), "Adidas Ultraboost Running Shoes", "Premium running shoes for exceptional comfort", Category.CLOTHING, 149.99, 200, true, 20.0f, null, 3),
                new Product(UUID.randomUUID(), "The Great Gatsby by F. Scott Fitzgerald", "A classic novel depicting the Jazz Age", Category.BOOKS, 9.99, 500, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Bananas (1 lb)", "Fresh and organic bananas for a healthy diet", Category.FOOD, 1.99, 1000, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Pfizer COVID-19 Vaccine", "A highly effective COVID-19 vaccine", Category.HEALTHCARE, 0.0, 1000000, true, 100.0f, null, 1),
                new Product(UUID.randomUUID(), "Sony PlayStation 5", "Next-gen gaming console for immersive gaming experiences", Category.ELECTRONIC, 499.99, 75, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Levi's 501 Original Fit Jeans", "Iconic jeans known for their timeless style", Category.CLOTHING, 59.99, 300, true, 15.0f, null, 3),
                new Product(UUID.randomUUID(), "To Kill a Mockingbird by Harper Lee", "A classic novel exploring themes of racial injustice", Category.BOOKS, 11.99, 400, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Strawberries (1 lb)", "Fresh strawberries for delicious desserts", Category.FOOD, 3.49, 800, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Johnson & Johnson COVID-19 Vaccine", "A trusted COVID-19 vaccine option", Category.HEALTHCARE, 0.0, 500000, true, 95.0f, null, 1),
                new Product(UUID.randomUUID(), "Apple MacBook Pro 13-inch", "Powerful laptop for professionals and creatives", Category.ELECTRONIC, 1299.99, 30, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Nike Dri-FIT T-Shirt", "Moisture-wicking t-shirt for active lifestyles", Category.CLOTHING, 29.99, 250, true, 20.0f, null, 3),
                new Product(UUID.randomUUID(), "1984 by George Orwell", "A dystopian novel exploring surveillance and control", Category.BOOKS, 10.99, 300, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Avocado (1)", "Ripe avocado for healthy salads and snacks", Category.FOOD, 1.79, 1200, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Moderna COVID-19 Vaccine", "A highly effective COVID-19 vaccine", Category.HEALTHCARE, 0.0, 750000, true, 90.0f, null, 1),
                new Product(UUID.randomUUID(), "Sony 65-inch 4K LED TV", "High-quality LED TV for stunning visuals", Category.ELECTRONIC, 1199.99, 40, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "The Catcher in the Rye by J.D. Salinger", "A classic novel exploring teenage angst", Category.BOOKS, 8.99, 350, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Spinach (1 lb)", "Fresh and organic spinach for healthy salads", Category.FOOD, 2.49, 700, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Johnson & Johnson Band-Aids", "Essential first-aid bandages for minor injuries", Category.HEALTHCARE, 4.99, 2000, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "Apple iPad Pro 12.9-inch", "Powerful tablet for productivity and creativity", Category.ELECTRONIC, 1099.99, 60, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Calvin Klein Men's Boxer Briefs", "Comfortable and stylish underwear for men", Category.CLOTHING, 19.99, 180, true, 15.0f, null, 3),
                new Product(UUID.randomUUID(), "The Hobbit by J.R.R. Tolkien", "A fantasy adventure novel set in Middle-earth", Category.BOOKS, 7.99, 250, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Strawberries (1 lb)", "Fresh and organic strawberries for desserts", Category.FOOD, 3.99, 600, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Tylenol Extra Strength Pain Reliever", "Effective pain relief for headaches and pain", Category.HEALTHCARE, 6.49, 1500, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "Sony 43-inch 4K LED TV", "Compact and feature-rich LED TV", Category.ELECTRONIC, 799.99, 35, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Nike Women's Running Shoes", "High-performance running shoes for women", Category.CLOTHING, 139.99, 220, true, 20.0f, null, 3),
                new Product(UUID.randomUUID(), "The Lord of the Rings Trilogy by J.R.R. Tolkien", "Epic fantasy novels set in Middle-earth", Category.BOOKS, 24.99, 300, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Blueberries (1 lb)", "Fresh and organic blueberries for snacking", Category.FOOD, 4.99, 450, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Crest Pro-Health Toothpaste", "Advanced toothpaste for dental care", Category.HEALTHCARE, 3.99, 2800, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "Dell XPS 15 Laptop", "Premium laptop for professionals and gamers", Category.ELECTRONIC, 1499.99, 25, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Under Armour Men's Hoodie", "Warm and comfortable hoodie for men", Category.CLOTHING, 49.99, 170, true, 20.0f, null, 3),
                new Product(UUID.randomUUID(), "The Da Vinci Code by Dan Brown", "A gripping thriller with a blend of art and history", Category.BOOKS, 11.49, 400, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Kale (1 lb)", "Fresh and organic kale for healthy recipes", Category.FOOD, 2.99, 550, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Band-Aid Flexible Fabric Bandages", "Comfortable and flexible bandages for wound care", Category.HEALTHCARE, 3.49, 2200, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "Sony Noise-Canceling Headphones", "Premium headphones for immersive audio experiences", Category.ELECTRONIC, 299.99, 45, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Levi's Women's Skinny Jeans", "Stylish skinny jeans for women", Category.CLOTHING, 39.99, 190, true, 15.0f, null, 3),
                new Product(UUID.randomUUID(), "The Shining by Stephen King", "A classic horror novel set in an eerie hotel", Category.BOOKS, 9.99, 320, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Tomatoes (1 lb)", "Fresh and organic tomatoes for cooking", Category.FOOD, 2.29, 750, true, 0.0f, null, 5),
                new Product(UUID.randomUUID(), "Neutrogena Hydro Boost Water Gel", "Hydrating skincare product for radiant skin", Category.HEALTHCARE, 16.99, 1300, true, 10.0f, null, 1),
                new Product(UUID.randomUUID(), "Bose QuietComfort 35 II Headphones", "Top-rated noise-canceling headphones for music lovers", Category.ELECTRONIC, 349.99, 60, true, 10.0f, null, 2),
                new Product(UUID.randomUUID(), "Calvin Klein Women's Dress", "Elegant and fashionable dress for women", Category.CLOTHING, 69.99, 140, true, 20.0f, null, 3),
                new Product(UUID.randomUUID(), "The Hunger Games Trilogy by Suzanne Collins", "Dystopian novels of survival and rebellion", Category.BOOKS, 19.99, 250, true, 5.0f, null, 4),
                new Product(UUID.randomUUID(), "Organic Avocado (1)", "Ripe organic avocado for healthy salads", Category.FOOD, 1.99, 950, true, 0.0f, null, 5)
                // Puedes seguir agregando más productos con nombres y descripciones realistas según sea necesario
        );
    }
}
