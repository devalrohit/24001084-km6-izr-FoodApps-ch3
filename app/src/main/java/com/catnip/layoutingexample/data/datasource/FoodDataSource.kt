package com.catnip.layoutingexample.data.datasource

import com.catnip.layoutingexample.model.Food

interface FoodDataSource {
    fun getFoodMenu(): List<Food>
}

class FoodDataSourceImpl() : FoodDataSource {
    override fun getFoodMenu(): List<Food> {
        return mutableListOf(
            Food(
                name = "Ayam Goreng",
                price = "Rp.30.000",
                detailfood = "Ayam goreng ini merupakan salah satu menu favorit kami karena kami memilih daging yang berkualitas tinggi dan mengolahnya dengan rempah-rempah pilihan, sehingga menghasilkan cita rasa yang gurih dan nikmat.",
                imagefoodPictUrl = "https://img.freepik.com/photos-premium/cuisses-poulet-frit-isoles-fond-blanc_79161-405.jpg?w=826",
                location = "Lokasi",
                detailLocation = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationPictUrl =  "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Food(
                name = "Burger",
                price = "Rp.20.000",
                detailfood = "Burger kami disajikan dengan patty daging sapi segar yang dipanggang sempurna, disertai dengan keju leleh, sayuran segar, dan saus spesial, menciptakan pengalaman makan yang memuaskan.",
                imagefoodPictUrl = "https://i.pinimg.com/originals/01/a8/b2/01a8b20022d3ac8d1c0ad960e7b67466.jpg",
                location = "Lokasi",
                detailLocation = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationPictUrl =  "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Food(
                name = "Pizza",
                price = "Rp.50.000",
                detailfood = "Pizza kami dibuat dengan adonan yang lembut dan renyah, lalu dipadukan dengan beragam topping berkualitas tinggi seperti pepperoni, jamur segar, dan keju mozzarella, memberikan cita rasa yang khas dan menggugah selera.",
                imagefoodPictUrl = "https://img.taste.com.au/fRe6DyVS/w720-h480-cfill-q80/taste/2019/08/zucchini-and-ricotta-pizza-152910-1.jpg",
                location = "Lokasi",
                detailLocation = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationPictUrl =  "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Food(
                name = "Ramen",
                price = "Rp.40.000",
                detailfood = "Ramen kami terkenal dengan kuah kaldu yang kaya rasa dan mie yang kenyal. Disajikan dengan irisan daging ayam atau babi, telur rebus, dan sayuran segar, menciptakan hidangan yang lezat dan menghangatkan.",
                imagefoodPictUrl = "https://www.halfbakedharvest.com/wp-content/uploads/2021/01/30-Minute-Spicy-Miso-Chicken-Katsu-Ramen-1-1024x1536.jpg",
                location = "Lokasi",
                detailLocation = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationPictUrl =  "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Food(
                name = "Sushi",
                price = "Rp.30.000",
                detailfood = "Sushi kami disiapkan dengan teliti oleh chef berpengalaman menggunakan bahan-bahan segar terbaik. Tiap gigitannya memberikan perpaduan rasa yang unik antara nasi lembut dan isian yang beragam, memberikan pengalaman makan yang memuaskan.",
                imagefoodPictUrl = "https://jbimagery1.files.wordpress.com/2022/12/sushi-club-mk-19-bhavisha-surti-food-photographer-and-stylist-milton-keynes.jpg?w=768",
                location = "Lokasi",
                detailLocation = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationPictUrl =  "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Food(
                name = "Nasi Padang",
                price = "Rp.20.000",
                detailfood = "Nasi Padang kami terkenal dengan ragam hidangan khas Minang yang lezat, seperti rendang, ayam goreng, sambalado, dan gulai cubadak. Setiap suapannya menghadirkan cita rasa yang autentik dan menggugah selera.",
                imagefoodPictUrl = "https://64.media.tumblr.com/5126d534ccdc304a73e0ab3324aa3075/tumblr_pex49heqKH1v32ipio1_640.jpg",
                location = "Lokasi",
                detailLocation = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationPictUrl =  "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Food(
                name = "Bubur Ayam",
                price = "Rp.50.000",
                detailfood = "Bubur ayam kami disajikan dengan ayam suwir yang lembut, telur rebus, bawang goreng, dan kerupuk, disiram dengan kuah kaldu yang gurih. Cocok disantap sebagai sarapan atau camilan di segala waktu.",
                imagefoodPictUrl = "https://i0.wp.com/rasabunda.com/wp-content/uploads/2021/03/Bubur-Ayam.jpg?fit=449%2C600&ssl=1",
                location = "Lokasi",
                detailLocation = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locationPictUrl =  "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            )
        )
    }

}
