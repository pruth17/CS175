package edu.sjsu.project;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;


public class Tour extends TabActivity implements TabHost.OnTabChangeListener {

    ImageView mImageView;
    City[] ListOfCity;
    City temp;

    String[] CITY_SEE;
    String[] CITY_DINE;
    String[] CITY_SHOP;
    String[] CITY_STAY;
    int[] Image_SEE;
    int[] Image_DINE;
    int[] Image_SHOP;
    int[] Image_STAY;

    // List of Tours for cities
    // Brisbane
    String[] CITY1_SEE = {"South Bank Parkland"};
    String[] CITY1_DINE = {"River bar & Kitchen"};
    String[] CITY1_SHOP = {"Queen Street Mall"};
    String[] CITY1_STAY = {"Brisbane Marriott Hotel"};

    // Melbourne
    String[] CITY2_SEE = {"Royal Botanic Garden Victoria", "Puffing Billy Railway"};
    String[] CITY2_DINE = {"Flower Drum Restaurant", "Cumulus Inc."};
    String[] CITY2_SHOP = {"Melbourne Central", "Emporium Melbourne"};
    String[] CITY2_STAY = {"Crowne Plaza Melbourne", "DoubleTree by Hilton Hotel"};

    //Sydney
    String[] CITY3_SEE = {"Sydney Opera House", "Sydney Harbour Bridge", "Darling Harbour"};
    String[] CITY3_DINE = {"Aria Restaurant", "360 Bar and Dining"};
    String[] CITY3_SHOP = {"Westfield Sydney", "Harbourside"};
    String[] CITY3_STAY = {"Four Seasons Hotel"};

    //Berlin
    String[] CITY4_SEE = {"Brandenburg Gate", "East Side Gallery"};
    String[] CITY4_DINE = {"House of Small Wonder", "A Mano"};
    String[] CITY4_SHOP = {"Kaufhaus des Westens"};
    String[] CITY4_STAY = {"Westlin Grand Berlin"};

    //Frankfurt
    String[] CITY5_SEE = {"Palmengarten", "Romerberg"};
    String[] CITY5_DINE = {"Kabuki"};
    String[] CITY5_SHOP = {"Skyline Plaza"};
    String[] CITY5_STAY = {"Kabuki"};

    //Monaco
    String[] CITY6_SEE = {"Casino Monte-Carlo", "Prince's Palance of Monaco"};
    String[] CITY6_DINE = {"Blue Bay", "Huit & Demi"};
    String[] CITY6_SHOP = {"Metropole Shopping Monte-Carlo"};
    String[] CITY6_STAY = {"Kimpton Hotel"};

    //Paris
    String[] CITY7_SEE = {"Eiffel Tower", "Louvre Museum"};
    String[] CITY7_DINE = {"Epicure", "Guy Savoy", "Restaurant Kei"};
    String[] CITY7_SHOP = {"Italie Deux", "Passage de Havre"};
    String[] CITY7_STAY = {"Holiday Inn", "Lafayette"};

    //Naples
    String[] CITY8_SEE = {"Lowdermilk Park", "Naples Beach"};
    String[] CITY8_DINE = {"Truluck's"};
    String[] CITY8_SHOP = {"Waterside Shops", "Tin City Waterfront Shops"};
    String[] CITY8_STAY = {"Hilton Naples", "The Naples Beach Hotel & Golf Club"};

    //Milan
    String[] CITY9_SEE = {"Duomo di Milano", "Sforzesco Castle", "Galleria Vittorio Emanuele II"};
    String[] CITY9_DINE = {"Seta", "Niko Romito Space Milan"};
    String[] CITY9_SHOP = {"Galleria Vittorio Emanuele II"};
    String[] CITY9_STAY = {"Hyatt Centric Milan Centrale", "Radisson Blu Hotel"};

    //Rome
    String[] CITY10_SEE = {"South Bank Parkland"};
    String[] CITY10_DINE = {"Life Ristorante", "Roscioli Salumeria con Cucina"};
    String[] CITY10_SHOP = {"Shopping Mall Porta di Roma", "Galleria Alberto Sordi"};
    String[] CITY10_STAY = {"Crowne Plaza Rome - St Peter's", "Sheraton Roma Hotel"};

    //Miami
    String[] CITY11_SEE = {"Colosseum", "Pantheon"};
    String[] CITY11_DINE = {"Santorini by Georgios", "Michael's Genuine Food & Drink"};
    String[] CITY11_SHOP = {"Bayside Marketplace"};
    String[] CITY11_STAY = {"Embassy Suites", "Courtyard"};

    //LA
    String[] CITY12_SEE = {"Disneyland", "Hollywood Studios"};
    String[] CITY12_DINE = {"Roscoe's Chicken & Waffles"};
    String[] CITY12_SHOP = {"The Grove", "FIGat7th", "Beverly Center"};
    String[] CITY12_STAY = {"Freehand" , "Hilton Los Angeles Airport"};

    //NY
    String[] CITY13_SEE = {"Statue of Liberty", "Brooklyn Bridge"};
    String[] CITY13_DINE = {"Gramercy Tavern", "La Bernardin"};
    String[] CITY13_SHOP = {"Manhattan Mall", "Brookfield Place"};
    String[] CITY13_STAY = {"The Roosevelt Hotel", "Fairfield Inn & Suites"};

    //SF
    String[] CITY14_SEE = {"Golden Gate Bridge", "Alcatraz"};
    String[] CITY14_DINE = {"Rich Table", "Quince"};
    String[] CITY14_SHOP = {"Westfield San Fransisco Centre", "Japan Center"};
    String[] CITY14_STAY = {"Hilton SF Financial District", "Marriot Marquis"};

    //Barcelona
    String[] CITY15_SEE = {"La Sagrada Familia", "Park Guell", "Casa Mila"};
    String[] CITY15_DINE = {"Viana Barcelona", "Disfrutar Barcelona"};
    String[] CITY15_SHOP = {"Maremagnum", "Diagonal Mar"};
    String[] CITY15_STAY = {"Hotel SB Diagonal Zero Barcelona", "W Barcelona"};

    //Madrid
    String[] CITY16_SEE = {"Plaza Mayor", "El Retiro Park"};
    String[] CITY16_DINE = {"CEBO Madrid Restaurant"};
    String[] CITY16_SHOP = {"Centro Commercial La Vaguada", "Plenilunio"};
    String[] CITY16_STAY = {"Madrid Marriott Auditorium"};

    //Seville
    String[] CITY17_SEE = {"Plaza De Espana", "La Giralda"};
    String[] CITY17_DINE = {"Al Wadi"};
    String[] CITY17_SHOP = {"Los Arcos", "Nervion Plaza"};
    String[] CITY17_STAY = {"Hotel Alfonso XIII"};

    //Moscow
    String[] CITY18_SEE = {"Red Square", "St Basil's Cathedral"};
    String[] CITY18_DINE = {"Sempre Moscow", "Mari Vanna"};
    String[] CITY18_SHOP = {"Aviapark", "Okhotny Ryad"};
    String[] CITY18_STAY = {"Moscow Marriott Grand Hotel"};

    //St. Petersburg
    String[] CITY19_SEE = {"Peterhof", "State Hermitage Museum"};
    String[] CITY19_DINE = {"Yat'", "Palkin"};
    String[] CITY19_SHOP = {"Galleria Shopping Mall", "Nevsky Centre"};
    String[] CITY19_STAY = {"Saint Petersburg", "Courtyard"};

    //Munich
    String[] CITY20_SEE = {"Marienplatz", "English Garden"};
    String[] CITY20_DINE = {"Resaurant Savanna Munich"};
    String[] CITY20_SHOP = {"Olympia-Einkaufszentrum"};
    String[] CITY20_STAY = {"Hilton Munich City", "Aloft Munich"};

    //List of tour for drawings/flags
    //Brisbane
//    int[] CITY1_Image_SEE = {R.drawable.flag_australia};
//    int[] CITY1_Image_DINE = {R.drawable.flag_australia};
//    int[] CITY1_Image_SHOP = {R.drawable.flag_australia};
//    int[] CITY1_Image_STAY = {R.drawable.flag_australia};
//
//    //Melbourne
//    int[] CITY2_Image_SEE = {R.drawable.flag_australia,R.drawable.flag_australia};
//    int[] CITY2_Image_DINE = {R.drawable.flag_australia,R.drawable.flag_australia};
//    int[] CITY2_Image_SHOP = {R.drawable.flag_australia,R.drawable.flag_australia};
//    int[] CITY2_Image_STAY = {R.drawable.flag_australia,R.drawable.flag_australia};
//
//    //Sydney
//    int[] CITY3_Image_SEE = {R.drawable.flag_australia,R.drawable.flag_australia,R.drawable.flag_australia};
//    int[] CITY3_Image_DINE = {R.drawable.flag_australia,R.drawable.flag_australia};
//    int[] CITY3_Image_SHOP = {R.drawable.flag_australia,R.drawable.flag_australia};
//    int[] CITY3_Image_STAY = {R.drawable.flag_australia};
//
//    //Berlin
//    int[] CITY4_Image_SEE = {R.drawable.flag_germany,R.drawable.flag_australia};
//    int[] CITY4_Image_DINE = {R.drawable.flag_germany,R.drawable.flag_australia};
//    int[] CITY4_Image_SHOP = {R.drawable.flag_germany,R.drawable.flag_australia};
//    int[] CITY4_Image_STAY = {R.drawable.flag_germany,R.drawable.flag_australia};
//
//    //Munich
//    int[] CITY20_Image_SEE = {R.drawable.flag_germany,R.drawable.flag_australia};
//    int[] CITY20_Image_DINE = {R.drawable.flag_germany};
//    int[] CITY20_Image_SHOP = {R.drawable.flag_germany};
//    int[] CITY20_Image_STAY = {R.drawable.flag_germany,R.drawable.flag_australia};
//
//    //Frankfurt
//    int[] CITY5_Image_SEE = {R.drawable.flag_germany,R.drawable.flag_australia};
//    int[] CITY5_Image_DINE = {R.drawable.flag_germany};
//    int[] CITY5_Image_SHOP = {R.drawable.flag_germany};
//    int[] CITY5_Image_STAY = {R.drawable.flag_germany};
//
//    //Monaco
//    int[] CITY6_Image_SEE = {R.drawable.flag_france,R.drawable.flag_australia};
//    int[] CITY6_Image_DINE = {R.drawable.flag_france,R.drawable.flag_australia};
//    int[] CITY6_Image_SHOP = {R.drawable.flag_france};
//    int[] CITY6_Image_STAY = {R.drawable.flag_france};
//
//    //Paris
//    int[] CITY7_Image_SEE = {R.drawable.flag_france,R.drawable.flag_australia};
//    int[] CITY7_Image_DINE = {R.drawable.flag_france,R.drawable.flag_australia,R.drawable.flag_australia};
//    int[] CITY7_Image_SHOP = {R.drawable.flag_france,R.drawable.flag_australia};
//    int[] CITY7_Image_STAY = {R.drawable.flag_france,R.drawable.flag_australia};
//
//    //Naples
//    int[] CITY8_Image_SEE = {R.drawable.flag_italy,R.drawable.flag_australia};
//    int[] CITY8_Image_DINE = {R.drawable.flag_italy};
//    int[] CITY8_Image_SHOP = {R.drawable.flag_italy,R.drawable.flag_australia};
//    int[] CITY8_Image_STAY = {R.drawable.flag_italy,R.drawable.flag_australia};
//
//    //Milan
//    int[] CITY9_Image_SEE = {R.drawable.flag_italy,R.drawable.flag_australia,R.drawable.flag_australia};
//    int[] CITY9_Image_DINE = {R.drawable.flag_italy,R.drawable.flag_australia};
//    int[] CITY9_Image_SHOP = {R.drawable.flag_italy};
//    int[] CITY9_Image_STAY = {R.drawable.flag_italy,R.drawable.flag_australia};
//
//    //Rome
//    int[] CITY10_Image_SEE = {R.drawable.flag_italy};
//    int[] CITY10_Image_DINE = {R.drawable.flag_italy,R.drawable.flag_australia};
//    int[] CITY10_Image_SHOP = {R.drawable.flag_italy,R.drawable.flag_australia};
//    int[] CITY10_Image_STAY = {R.drawable.flag_italy,R.drawable.flag_australia};
//
//    //Miami
//    int[] CITY11_Image_SEE = {R.drawable.flag_us,R.drawable.flag_australia};
//    int[] CITY11_Image_DINE = {R.drawable.flag_us,R.drawable.flag_australia};
//    int[] CITY11_Image_SHOP = {R.drawable.flag_us};
//    int[] CITY11_Image_STAY = {R.drawable.flag_us,R.drawable.flag_australia};
//
//    //Los Angeles
//    int[] CITY12_Image_SEE = {R.drawable.flag_us,R.drawable.flag_australia};
//    int[] CITY12_Image_DINE = {R.drawable.flag_us};
//    int[] CITY12_Image_SHOP = {R.drawable.flag_us,R.drawable.flag_australia,R.drawable.flag_australia};
//    int[] CITY12_Image_STAY = {R.drawable.flag_us,R.drawable.flag_australia};
//
//    //New York
//    int[] CITY13_Image_SEE = {R.drawable.flag_us,R.drawable.flag_australia};
//    int[] CITY13_Image_DINE = {R.drawable.flag_us,R.drawable.flag_australia};
//    int[] CITY13_Image_SHOP = {R.drawable.flag_us,R.drawable.flag_australia};
//    int[] CITY13_Image_STAY = {R.drawable.flag_us,R.drawable.flag_australia};
//
//    //San Fransisco
//    int[] CITY14_Image_SEE = {R.drawable.flag_us,R.drawable.flag_australia};
//    int[] CITY14_Image_DINE = {R.drawable.flag_us,R.drawable.flag_australia};
//    int[] CITY14_Image_SHOP = {R.drawable.flag_us,R.drawable.flag_australia};
//    int[] CITY14_Image_STAY = {R.drawable.flag_us,R.drawable.flag_australia};
//
//    //Barcelona
//    int[] CITY15_Image_SEE = {R.drawable.flag_spain,R.drawable.flag_australia,R.drawable.flag_australia};
//    int[] CITY15_Image_DINE = {R.drawable.flag_spain,R.drawable.flag_australia};
//    int[] CITY15_Image_SHOP = {R.drawable.flag_spain,R.drawable.flag_australia};
//    int[] CITY15_Image_STAY = {R.drawable.flag_spain,R.drawable.flag_australia};
//
//    //Madrid
//    int[] CITY16_Image_SEE = {R.drawable.flag_spain,R.drawable.flag_australia};
//    int[] CITY16_Image_DINE = {R.drawable.flag_spain};
//    int[] CITY16_Image_SHOP = {R.drawable.flag_spain,R.drawable.flag_australia};
//    int[] CITY16_Image_STAY = {R.drawable.flag_spain};
//
//    //Seville
//    int[] CITY17_Image_SEE = {R.drawable.flag_spain,R.drawable.flag_australia};
//    int[] CITY17_Image_DINE = {R.drawable.flag_spain};
//    int[] CITY17_Image_SHOP = {R.drawable.flag_spain,R.drawable.flag_australia};
//    int[] CITY17_Image_STAY = {R.drawable.flag_spain};
//
//    //Moscow
//    int[] CITY18_Image_SEE = {R.drawable.flag_russia,R.drawable.flag_australia};
//    int[] CITY18_Image_DINE = {R.drawable.flag_russia,R.drawable.flag_australia};
//    int[] CITY18_Image_SHOP = {R.drawable.flag_russia,R.drawable.flag_australia};
//    int[] CITY18_Image_STAY = {R.drawable.flag_russia};
//
//    //St. Petersburg
//    int[] CITY19_Image_SEE = {R.drawable.flag_russia,R.drawable.flag_australia};
//    int[] CITY19_Image_DINE = {R.drawable.flag_russia,R.drawable.flag_australia};
//    int[] CITY19_Image_SHOP = {R.drawable.flag_russia,R.drawable.flag_australia};
//    int[] CITY19_Image_STAY = {R.drawable.flag_russia,R.drawable.flag_australia};



    // make variables for all the cities like above

    int res;
    ListView mListView;
    ListView mListView2;
    ListView mListView3;
    ListView mListView4;
    PerAdapter mAdapter;
    PerAdapter mAdapter1;
    PerAdapter mAdapter2;
    PerAdapter mAdapter3;

    private TabHost tabHost;
    private static final String LIST1_TAB_TAG = "SEE & DO";
    private static final String LIST2_TAB_TAG = "DINE";
    private static final String LIST3_TAB_TAG = "SHOP";
    private static final String LIST4_TAB_TAG = "STAY";
    String cityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        tabHost = getTabHost();
        tabHost.setOnTabChangedListener(mOnTabChangedListener);
        //mOnTabChangedListener.onTabChanged("SEE & DO");
        mListView = findViewById(R.id.listview4);
        mListView2 = findViewById(R.id.listview5);
        mListView3 = findViewById(R.id.listview6);
        mListView4 = findViewById(R.id.listview7);
        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
            cityName = mBundle.getString("CityName");
        }


        if(cityName.equals("Brisbane"))
        {
            CITY_SEE = CITY1_SEE;
            CITY_DINE = CITY1_DINE;
            CITY_SHOP = CITY1_SHOP;
            CITY_STAY = CITY1_STAY;
//            Image_SEE = CITY1_Image_SEE;
//            Image_DINE = CITY1_Image_DINE;
//            Image_SHOP = CITY1_Image_SHOP;
//            Image_STAY = CITY1_Image_STAY;
        }

        else if(cityName.equals("Melbourne"))
        {
            CITY_SEE = CITY2_SEE;
            CITY_DINE = CITY2_DINE;
            CITY_SHOP = CITY2_SHOP;
            CITY_STAY = CITY2_STAY;
//            Image_SEE = CITY2_Image_SEE;
//            Image_DINE = CITY2_Image_DINE;
//            Image_SHOP = CITY2_Image_SHOP;
//            Image_STAY = CITY2_Image_STAY;
        }

        else if(cityName.equals("Sydney"))
        {
            CITY_SEE = CITY3_SEE;
            CITY_DINE = CITY3_DINE;
            CITY_SHOP = CITY3_SHOP;
            CITY_STAY = CITY3_STAY;
//            Image_SEE = CITY3_Image_SEE;
//            Image_DINE = CITY3_Image_DINE;
//            Image_SHOP = CITY3_Image_SHOP;
//            Image_STAY = CITY3_Image_STAY;
        }

        else if(cityName.equals("Berlin"))
        {
            CITY_SEE = CITY4_SEE;
            CITY_DINE = CITY4_DINE;
            CITY_SHOP = CITY4_SHOP;
            CITY_STAY = CITY4_STAY;
//            Image_SEE = CITY4_Image_SEE;
//            Image_DINE = CITY4_Image_DINE;
//            Image_SHOP = CITY4_Image_SHOP;
//            Image_STAY = CITY4_Image_STAY;
        }

        else if(cityName.equals("Munich"))
        {
            CITY_SEE = CITY20_SEE;
            CITY_DINE = CITY20_DINE;
            CITY_SHOP = CITY20_SHOP;
            CITY_STAY = CITY20_STAY;
//            Image_SEE = CITY20_Image_SEE;
//            Image_DINE = CITY20_Image_DINE;
//            Image_SHOP = CITY20_Image_SHOP;
//            Image_STAY = CITY20_Image_STAY;
        }

        else if(cityName.equals("Frankfurt"))
        {
            CITY_SEE = CITY5_SEE;
            CITY_DINE = CITY5_DINE;
            CITY_SHOP = CITY5_SHOP;
            CITY_STAY = CITY5_STAY;
//            Image_SEE = CITY5_Image_SEE;
//            Image_DINE = CITY5_Image_DINE;
//            Image_SHOP = CITY5_Image_SHOP;
//            Image_STAY = CITY5_Image_STAY;
        }

        else if(cityName.equals("Monaco"))
        {
            CITY_SEE = CITY6_SEE;
            CITY_DINE = CITY6_DINE;
            CITY_SHOP = CITY6_SHOP;
            CITY_STAY = CITY6_STAY;
//            Image_SEE = CITY6_Image_SEE;
//            Image_DINE = CITY6_Image_DINE;
//            Image_SHOP = CITY6_Image_SHOP;
//            Image_STAY = CITY6_Image_STAY;
        }

        else if(cityName.equals("Paris"))
        {
            CITY_SEE = CITY7_SEE;
            CITY_DINE = CITY7_DINE;
            CITY_SHOP = CITY7_SHOP;
            CITY_STAY = CITY7_STAY;
//            Image_SEE = CITY7_Image_SEE;
//            Image_DINE = CITY7_Image_DINE;
//            Image_SHOP = CITY7_Image_SHOP;
//            Image_STAY = CITY7_Image_STAY;
        }

        else if(cityName.equals("Naples"))
        {
            CITY_SEE = CITY8_SEE;
            CITY_DINE = CITY8_DINE;
            CITY_SHOP = CITY8_SHOP;
            CITY_STAY = CITY8_STAY;
//            Image_SEE = CITY8_Image_SEE;
//            Image_DINE = CITY8_Image_DINE;
//            Image_SHOP = CITY8_Image_SHOP;
//            Image_STAY = CITY8_Image_STAY;
        }

        else if(cityName.equals("Milan"))
        {
            CITY_SEE = CITY9_SEE;
            CITY_DINE = CITY9_DINE;
            CITY_SHOP = CITY9_SHOP;
            CITY_STAY = CITY9_STAY;
//            Image_SEE = CITY9_Image_SEE;
//            Image_DINE = CITY9_Image_DINE;
//            Image_SHOP = CITY9_Image_SHOP;
//            Image_STAY = CITY9_Image_STAY;
        }

        else if(cityName.equals("Rome"))
        {
            CITY_SEE = CITY10_SEE;
            CITY_DINE = CITY10_DINE;
            CITY_SHOP = CITY10_SHOP;
            CITY_STAY = CITY10_STAY;
//            Image_SEE = CITY10_Image_SEE;
//            Image_DINE = CITY10_Image_DINE;
//            Image_SHOP = CITY10_Image_SHOP;
//            Image_STAY = CITY10_Image_STAY;
        }

        else if(cityName.equals("Miami"))
        {
            CITY_SEE = CITY11_SEE;
            CITY_DINE = CITY11_DINE;
            CITY_SHOP = CITY11_SHOP;
            CITY_STAY = CITY11_STAY;
//            Image_SEE = CITY11_Image_SEE;
//            Image_DINE = CITY11_Image_DINE;
//            Image_SHOP = CITY11_Image_SHOP;
//            Image_STAY = CITY11_Image_STAY;
        }

        else if(cityName.equals("Los Angeles"))
        {
            CITY_SEE = CITY12_SEE;
            CITY_DINE = CITY12_DINE;
            CITY_SHOP = CITY12_SHOP;
            CITY_STAY = CITY12_STAY;
//            Image_SEE = CITY12_Image_SEE;
//            Image_DINE = CITY12_Image_DINE;
//            Image_SHOP = CITY12_Image_SHOP;
//            Image_STAY = CITY12_Image_STAY;
        }

        else if(cityName.equals("New York"))
        {
            CITY_SEE = CITY13_SEE;
            CITY_DINE = CITY13_DINE;
            CITY_SHOP = CITY13_SHOP;
            CITY_STAY = CITY13_STAY;
//            Image_SEE = CITY13_Image_SEE;
//            Image_DINE = CITY13_Image_DINE;
//            Image_SHOP = CITY13_Image_SHOP;
//            Image_STAY = CITY13_Image_STAY;
        }

        else if(cityName.equals("San Francisco"))
        {
            CITY_SEE = CITY14_SEE;
            CITY_DINE = CITY14_DINE;
            CITY_SHOP = CITY14_SHOP;
            CITY_STAY = CITY14_STAY;
//            Image_SEE = CITY14_Image_SEE;
//            Image_DINE = CITY14_Image_DINE;
//            Image_SHOP = CITY14_Image_SHOP;
//            Image_STAY = CITY14_Image_STAY;
        }

        else if(cityName.equals("Barcelona"))
        {
            CITY_SEE = CITY15_SEE;
            CITY_DINE = CITY15_DINE;
            CITY_SHOP = CITY15_SHOP;
            CITY_STAY = CITY15_STAY;
//            Image_SEE = CITY15_Image_SEE;
//            Image_DINE = CITY15_Image_DINE;
//            Image_SHOP = CITY15_Image_SHOP;
//            Image_STAY = CITY15_Image_STAY;
        }

        else if(cityName.equals("Madrid"))
        {
            CITY_SEE = CITY16_SEE;
            CITY_DINE = CITY16_DINE;
            CITY_SHOP = CITY16_SHOP;
            CITY_STAY = CITY16_STAY;
//            Image_SEE = CITY16_Image_SEE;
//            Image_DINE = CITY16_Image_DINE;
//            Image_SHOP = CITY16_Image_SHOP;
//            Image_STAY = CITY16_Image_STAY;
        }

        else if(cityName.equals("Seville"))
        {
            CITY_SEE = CITY17_SEE;
            CITY_DINE = CITY17_DINE;
            CITY_SHOP = CITY17_SHOP;
            CITY_STAY = CITY17_STAY;
//            Image_SEE = CITY17_Image_SEE;
//            Image_DINE = CITY17_Image_DINE;
//            Image_SHOP = CITY17_Image_SHOP;
//            Image_STAY = CITY17_Image_STAY;
        }

        else if(cityName.equals("Moscow"))
        {
            CITY_SEE = CITY18_SEE;
            CITY_DINE = CITY18_DINE;
            CITY_SHOP = CITY18_SHOP;
            CITY_STAY = CITY18_STAY;
//            Image_SEE = CITY18_Image_SEE;
//            Image_DINE = CITY18_Image_DINE;
//            Image_SHOP = CITY18_Image_SHOP;
//            Image_STAY = CITY18_Image_STAY;
        }

        else if(cityName.equals("St. Petersburg"))
        {
            CITY_SEE = CITY19_SEE;
            CITY_DINE = CITY19_DINE;
            CITY_SHOP = CITY19_SHOP;
            CITY_STAY = CITY19_STAY;
//            Image_SEE = CITY19_Image_SEE;
//            Image_DINE = CITY19_Image_DINE;
//            Image_SHOP = CITY19_Image_SHOP;
//            Image_STAY = CITY19_Image_STAY;
        }

        tabHost.addTab(tabHost.newTabSpec(LIST1_TAB_TAG).setIndicator(LIST1_TAB_TAG).setContent(Dummy));
        tabHost.addTab(tabHost.newTabSpec(LIST2_TAB_TAG).setIndicator(LIST2_TAB_TAG).setContent(Dummy));

        tabHost.addTab(tabHost.newTabSpec(LIST3_TAB_TAG).setIndicator(LIST3_TAB_TAG).setContent(Dummy));

        tabHost.addTab(tabHost.newTabSpec(LIST4_TAB_TAG).setIndicator(LIST4_TAB_TAG).setContent(Dummy));


    }
    private final TabHost.TabContentFactory Dummy = new TabHost.TabContentFactory()
    {
        @Override
        public View createTabContent(String tag)
        {
            return mListView;
        }
    };

    private TabHost.OnTabChangeListener mOnTabChangedListener = new TabHost.OnTabChangeListener()
    {
        @Override
        public void onTabChanged(String tabId)
        {
            String[] data;

            if (tabId.equalsIgnoreCase("SEE & DO")){
                mAdapter = new PerAdapter(Tour.this, CITY_SEE);
                mListView.setAdapter(mAdapter);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent mIntent = new Intent(Tour.this, Description.class);
                        mIntent.putExtra("TourName", CITY_SEE[i]);
                        startActivity(mIntent);
                    }
                });

            }

            else if (tabId.equalsIgnoreCase("DINE")){
                mAdapter1 = new PerAdapter(Tour.this, CITY_DINE);
                mListView.setAdapter(mAdapter1);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent mIntent = new Intent(Tour.this, Description.class);
                        mIntent.putExtra("TourName", CITY_DINE[i]);
                        startActivity(mIntent);
                    }
                });

            }

            else if(tabId.equalsIgnoreCase("SHOP")){
                mAdapter2 = new PerAdapter(Tour.this, CITY_SHOP);
                mListView.setAdapter(mAdapter2);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent mIntent = new Intent(Tour.this, Description.class);
                        mIntent.putExtra("TourName", CITY_SHOP[i]);
                        startActivity(mIntent);
                    }
                });

            }
            else if(tabId.equalsIgnoreCase("STAY")) {
                mAdapter3 = new PerAdapter(Tour.this, CITY_STAY);
                mListView.setAdapter(mAdapter3);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent mIntent = new Intent(Tour.this, Description.class);
                        mIntent.putExtra("TourName", CITY_STAY[i]);
                        startActivity(mIntent);
                    }
                });

            }


        }
    };

    @Override
    public void onTabChanged(String tabId) {

    }
}