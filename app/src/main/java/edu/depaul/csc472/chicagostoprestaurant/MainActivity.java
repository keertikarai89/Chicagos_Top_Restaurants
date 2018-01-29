package edu.depaul.csc472.chicagostoprestaurant;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends ListActivity {

    private static final String TAG = "MainActivity";
    //private static final int RATING = 100; // request code

    private Restaurant selectedRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_details);

        setListAdapter(new RestaurantAdapter());
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Log.d(TAG, "onListItemClick position=" + position + " id=" + id + " " + RESTAURANTS[position].getName());
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("RestaurantName", RESTAURANTS[position].getName());
        intent.putExtra("RestaurantDescription", RESTAURANTS[position].getLongDescription());
        intent.putExtra("RestaurantIcon", Restaurant.getIconResource(RESTAURANTS[position].getType()));
        //intent.putExtra("RestaurantWebsite", RESTAURANTS[position].getWebsite());
        //intent.putExtra("RestaurantRating", selectedRestaurant.getRating());
        //startActivityForResult(intent, RATING);
        startActivity(intent);
    }

    class RestaurantAdapter extends BaseAdapter {

        private LayoutInflater inflater;

        @Override
        public int getCount() {
            return RESTAURANTS.length;
        }

        @Override
        public Object getItem(int i) {
            return RESTAURANTS[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView (int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (convertView == null) {
                if (inflater == null)
                    inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.restaurant_list, parent, false);
            }

            ImageView icon = row.findViewById(R.id.image);
            TextView name = row.findViewById(R.id.text1);
            TextView description = row.findViewById(R.id.text2);
            //TextView website = row.findViewById(R.id.text3);

            Restaurant restaurant = RESTAURANTS[position];
            name.setText(restaurant.getName());
            description.setText(restaurant.getShortDescription());
            icon.setImageResource(Restaurant.getIconResource(restaurant.getType()));
            //website.setText(restaurant.getWebsite());
            return row;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static final Restaurant[] RESTAURANTS = {
            new Restaurant("Smoque BBQ",
                    Restaurant.Type.American,
                    "3800 N Pulaski Rd\n" +
                            "Chicago, IL 60641\n" +
                            "Phone: (773) 545-7427",
                    "Smoque (smōk) BBQ is a neighborhood kind of place that cooks up BBQ good enough to make it a true destination. It was created by five regular guys who happen to be passionate about food in general and BBQ in particular.\n\n" +
                            "Price:\n" +
                            "$$-$$$\n\n" +
                            "Cuisines:\n" +
                            "American, Barbecue, Gluten Free Options\n\n"+
                            "Website:\n" +
                            "http://www.smoquebbq.com"),

            new Restaurant("Bavettes Bar",
                    Restaurant.Type.American,
                    "218 W Kinzie St\n" +
                            "Chicago, IL 60654\n" +
                            "Phone: (312) 624-8154",
                    "A stylish departure from a traditional steakhouse, Bavette’s embraces French flair without the formality, blending fine dining with unabashed fun. Guests can indulge in timeless steakhouse fare, including seafood towers, richly flavorful ribeyes, classic side dishes, and house made desserts, paired with strong cocktails and a well-curated international wine list. The gilded space features red leather banquettes, glowing chandeliers, and lively jazz.\n\n" +
                            "Price:\n" +
                            "$$$$\n\n" +
                            "Cuisines:\n" +
                            "American, Steakhouse, Gluten Free Options\n\n"+
                            "Website:\n" +
                            "http://bavettessteakhouse.com"),

            new Restaurant("The Capital Grille",
                    Restaurant.Type.American,
                    "633 North St. Clair Street\n" +
                            "Chicago, IL  60611\n" +
                            "Phone: (312) 337-9400",
                    "From the moment you step into The Capital Grille, the experience is one of comfortable elegance. African mahogany paneling and Art Deco chandeliers provide a warm, stately setting for our nationally renowned dry-aged steaks, fresh seafood, and acclaimed world-class wines.\n" +
                            "Price\n" +
                            "$$$$\n\n" +
                            "Cuisines:\n" +
                            "American, Steakhouse, Vegetarian Friendly\n\n"+
                            "Website:\n" +
                            "http://www.thecapitalgrille.com"),

            new Restaurant("Gibsons Bar & Steakhouse",
                    Restaurant.Type.American,
                    "1028 North Rush Street\n" +
                            "Chicago, IL  60611\n" +
                            "Phone: (312) 266-8999",
                    "Gibsons Bar & Steakhouse has been a Chicago steakhouse icon since opening its doors 27 years ago in May of 1989. The classic American steakhouse features USDA Gibsons Prime Angus beef, fresh fish, classic cocktails, an extensive wine list and uncompromising service.\n" +
                            "Price\n" +
                            "$$$$\n\n" +
                            "Cuisines:\n" +
                            "American, Steakhouse, Bar\n\n"+
                            "Website:\n" +
                            "https://www.gibsonssteakhouse.com"),

            new Restaurant("India House",
                    Restaurant.Type.Indian,
                    "59 W Grand Ave\n" +
                            "Chicago, IL  60654\n" +
                            "Phone: (312) 645-9500",
                    "Food is an integral part of India 's culture, with cuisines differing according to community, region, and state. Indian cuisine is characterized by a great variety of foods, spices, and cooking techniques. The founder of India House, Jagmohan Jayara, has always wished to serve society with food that touches the soul and brings to life the Indian culture.\n\n" +
                            "Price\n" +
                            "$$-$$$\n\n" +
                            "Cuisines:\n" +
                            "Indian, Asian, Vegetarian Friendly\n\n"+
                            "Website:\n" +
                            "http://www.indiahousechicago.com"),

            new Restaurant("Chicago Curry House",
                    Restaurant.Type.Indian,
                    "899 S Plymouth Ct\n" +
                            "Chicago, IL  60605\n" +
                            "Phone: (312) 362-9999",
                    "Curry House Indian and Napali Restaurant, located in the South Loop area presents yet another facet of the abundant culrutal diversity of Chicago. Chicago Curry House features an array of classic Indian and Nepali food, including dishes like \"momo\" (dumplings with sauce), traditional Nepali \"Thalis' (meal combinations), \"dal-bhaat\" (rice and lentils) and \"gundruk\" (slightly-fermented and dried vegetables).\n\n" +
                            "Price\n" +
                            "$$-$$$\n\n" +
                            "Cuisines:\n" +
                            "Indian, Asian, Nepali\n\n" +
                            "Website:\n" +
                            "http://curryhouseonline.com"),

            new Restaurant("Gaylord Indian Restaurant",
                    Restaurant.Type.Indian,
                    "100 E Walton St\n" +
                            "Chicago, IL  60611-1448\n" +
                            "Phone: (312) 664-1700",
                    "Gaylord Chicago offers a sophisticated setting and the freshest Indian cuisine available. Each day chefs use the freshest ingredients in their lunch buffet and al a carte menus featuring a variety of regional fare and staple favorites, offering a consistency in freshness not found elsewhere. Gaylord serves Northern Indian cuisine, which has been influenced by the Moguls, consists mainly of dishes and breads cooked in the clay oven (“tandoor”) and meats and vegetables slowly cooked in either tomato, onion, ground nut based or vegetable cased sauces, which are expertly seasoned according to the type of dish. \n\n" +
                            "Price\n" +
                            "$$-$$$\n\n" +
                            "Cuisines:\n" +
                            "Indian, Vegetarian Friendly, Vegan Options\n\n" +
                            "Website:\n" +
                            "http://gaylordil.com"),

            new Restaurant("Pub Royale",
                    Restaurant.Type.Indian,
                    "2049 W Division St\n" +
                            "Chicago, IL  60622\n" +
                            "Phone: (773) 661-6874",
                    "Pub Royale is a beer-driven pub located in Wicker Park, serving up Anglo-Indian fare in an eclectic, convivial setting. A didactic yet approachable beer menu champions quality and craft above all else, ranging from rare finds to hometown heroes. On the cocktail side, we feature a rotation of seasonal Royale Cups, created in partnership with our friends at Letherbee. The food and drink find a perfect backdrop in an equally eccentric space, with touches of Indian pop culture and a Bohemian feel. Pub Royale was name one of the 50 Best New Restaurants in 2016 by Bon Appetit magazine.\n\n" +
                            "Price\n" +
                            "$$-$$$\n\n" +
                            "Cuisines:\n" +
                            "Indian, Bar, Pub, Asian, Vegetarian Friendly, Vegan Options\n\n" +
                            "Website:\n" +
                            "http://www.pubroyale.com"),

            new Restaurant("Shanghai Terrace",
                    Restaurant.Type.Chinese,
                    "108 E Superior St\n" +
                            "Chicago, IL  60611\n" +
                            "Phone: (312) 573-6744",
                    "Voted the number one \"Chinese Restaurant in Chicago\" by Zagat Survey, Shanghai Terrace offers Cantonese delicacies amidst a 1930s supper club décor, or outside on The Terrace with spectacular skyline views and cocktails. Step into the seductive setting of the restaurant and savour distinctive cuisine, consistently honoured with the AAA Four Diamond Award. At lunch, bamboo baskets of freshly steamed dim sum contain favourites such as barbecue pork buns, Peking Duck and shrimp and chive dumplings.\n\n" +
                            "Price\n" +
                            "$$$$\n\n" +
                            "Cuisines:\n" +
                            "Chinese, Asian, Gluten Free Options\n\n" +
                            "Website: \n" +
                            "http://chicago.peninsula.com/en/fine-dining/shanghai-terrace-chinese-restaurant"),

            new Restaurant("Moon Palace",
                    Restaurant.Type.Chinese,
                    "216 W. Cermak Rd.\n" +
                            "Chicago, IL  60616\n" +
                            "Phone: (312) 225-4081",
                    "A jewel resting at the entrance of Chicago’s Chinatown, Moon Palace offers quality food, a comfortable and relaxed ambiance, and a full bar menu. Whether you are coming to enjoy a nice lunch date or preparing for a night out with the family, Moon Palace is the perfect place to be.\n\n" +
                            "Price\n" +
                            "$$-$$$\n\n" +
                            "Cuisines:\n" +
                            "Chinese, Asian\n\n" +
                            "Website:\n" +
                            "http://www.moonpalacerestaurant.com"),

            new Restaurant("Volare",
                    Restaurant.Type.Italian,
                    "201 E Grand Ave\n" +
                            "Chicago, IL  60611\n" +
                            "Phone: (312) 410-9900",
                    "Established in 1997, Volare reflects the look and feel of an old world Italian restaurant. The food represents the finest traditional Italian cuisine with modern accents.\n\n" +
                            "Price\n" +
                            "$$-$$$\n\n" +
                            "Cuisines:\n" +
                            "Italian, Vegetarian Friendly, Vegan Options\n\n" +
                            "Website:\n" +
                            "http://volarerestaurant.com"),

            new Restaurant("RPM Italian",
                    Restaurant.Type.Italian,
                    "52 W Illinois St\n" +
                            "Chicago, IL  60654\n" +
                            "Phone: (312) 222-1888",
                    "Located in Chicago’s River North neighborhood, RPM Italian is modern in approach and Italian in spirit and features a contemporary, chef-driven menu with dishes meant to be shared. Menu highlights include more than a dozen fresh pastas made in-house daily, slow-roasted meats, wild fish and seafood, and celebrated Italian classics with an elevated twist. Signature RPM cocktails or any wine from the extensive list, top off the dining experience. RPM Italian’s chic space is set in tones of black, whites and grays and boasts rich woods and leathers, making it the perfect spot to enjoy a great meal, night out or simply a late night bite.\n\n" +
                            "Price\n" +
                            "$$$$\n\n" +
                            "Cuisines:\n" +
                            "Italian, Vegetarian Friendly, Vegan Options , Gluten Free Options\n\n" +
                            "Website:\n" +
                            "http://rpmrestaurants.com"),

            new Restaurant("Trattoria No. 10",
                    Restaurant.Type.Italian,
                    "10 N Dearborn St #1\n" +
                            "Chicago, IL  60602\n" +
                            "Phone: (312) 984-1718",
                    "CLASSIC ITALIAN DISHES WITH A CONTEMPORARY FLAIR HAVE MADE TRATTORIA NO.10 A CHICAGO FAVORITE SINCE 1989. SPECIALTIES ON THE DAILY MENU INCLUDE UNIQUE, HOMEMADE RAVIOLI, FRESHLY PREPARED RISOTTO, INVENTIVE PASTAS, SUSTAINABLE FISH SELECTIONS, VEAL SCALLOPINE AND GRASS FED NY STRIP STEAK. THE SUBDUED ELEGANCE OF THE INTERIOR WITH ARCHED WALKWAYS, MURALS AND ORIGINAL ART PROVIDES AN INTIMATE ATMOSPHERE THAT IS PERFECT FOR BUSINESS LUNCHES, PRE-THEATER DINING, ROMANTIC DINNERS OR PRIVATE PARTIES. IN MAY OF 2010, TRATTORIA NO.10 BECAME ONE OF THE FIRST RESTAURANTS IN CHICAGO TO BECOME \"GUARANTEED GREEN\". A DISTINCTION THAT RECOGNIZES US AS A RESTAURANT THAT HAS ACHIEVED A HIGH LEVEL OF ENVIRONMENTAL RESPONSIBILITY IN ALL ASPECTS OF OUR OPERATION - FROM OUR WATER AND ENERGY CONSERVATION EFFORTS, TO THE SUSTAINABLE LOCAL FOOD WE SERVE.\n\n" +
                            "Price\n" +
                            "$$-$$$\n\n" +
                            "Cuisines:\n" +
                            "Italian, Vegetarian Friendly, Vegan Options\n\n" +
                            "Website:\n" +
                            "http://www.trattoriaten.com"),

            new Restaurant("Siena Tavern",
                    Restaurant.Type.Italian,
                    "51 W Kinzie St\n" +
                            "Chicago, IL  60654\n" +
                            "Phone: (312) 595-1322",
                    "The 10,000 square foot space’s décor reflects a hybrid of a rustic Italian market, a fine dining restaurants, and a modern, industrial tavern, bridging old world comfort and hospitality with a contemporary menu and design. The bustling 200-person dining room and spacious bar landscape blends perfectly with Chicago’s energetic River North dining & nightlife scene. The notable wine collection and extensive hand-crafted cocktails compliment the from-scratch menu, created Top Chef and DineAmic Group Partner Fabio Viviani. Named “one of the most talented Chefs in the world” by Forbes, one should anticipate continuous smells of truffle, homemade Italian cuisine, and a dining experience you will never forget. Open 7 days a week, Siena Tavern offers a full lunch, dinner, and weekend brunch menu in addition to a skilled team dedicated to catering & private events.\n\n" +
                            "Price\n" +
                            "$$-$$$\n\n" +
                            "Cuisines:\n" +
                            "Italian, American, Bar\n\n" +
                            "Website:\n" +
                            "http://www.sienatavern.com"),











    };

}
