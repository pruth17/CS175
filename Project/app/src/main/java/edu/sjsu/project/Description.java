package edu.sjsu.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;

public class Description extends AppCompatActivity {
    String TourName;
    TextView text;
    Button mapButton;
    Button infoButton;
    TextView NameText;
    String nameOfPlace;
    TextView ratingText;
    private String text1;
    private PlacesDB DB;
    String ratingOfPlace;
    String DescriptionOfPlace;
    Desc[] listOfTours;
    Double latitude;
    Double longitude;
    Desc temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        DB = new PlacesDB(this);
        NameText = findViewById(R.id.textView2);
        ratingText = findViewById(R.id.textView3);
        mapButton = (Button) findViewById(R.id.button1);
        infoButton = findViewById(R.id.button2);
        DB.delete();
        DB.insert("South Bank Parkland", "Rating: 4.7/5", "South Bank is a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia. " +
                        "The precinct is located in the suburb of South Brisbane, on the southern bank of the Brisbane River.",
                "-27.481130", "153.022630" );
        DB.insert("River bar & Kitchen", "Rating: 4.3/5",
                "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.",
                "-27.468250" ,"153.039960");
        DB.insert("Queen Street Mall", "Rating: 4.4/5",
                "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.",
                "-27.469891" ,"153.024887");
        DB.insert("Brisbane Marriott Hotel", "Rating: 4.3/5",
                "Brisbane Marriott Hotel is in the city center and on the river walk.",
                "-27.509560","153.059970");
        DB.insert("Royal Botanic Garden Victoria", "Rating: 4.8/5",
                "Botanic gardens across two sites - Melbourne and Cranbourne.",
                "-36.405270","145.380410");
        DB.insert("Puffing Billy Railway", "Rating: 4.5/5",
                "A 2 ft 6 in narrow gauge heritage railway in the Dandenong Ranges in Melbourne, Australia",
                "-37.933270","145.440600");
        DB.insert("Flower Drum Restaurant", "Rating: 4.5/5",
                "Cantonese meals in a sprawling, red-carpeted restaurant with panels of Chinese art lining the walls",
                "-37.754280","-37.754280");
        DB.insert("Cumulus Inc.", "Rating: 4.4/5",
                "Bustling, high-ceilinged cafe/bar with an open kitchen and upmarket menu, in old rag trade building",
                "-32.039880","115.897700");
        DB.insert("Melbourne Central", "Rating: 4.4/5",
                "Melbourne Central is a large shopping centre, office, and public transport hub in the city of Melbourne, Victoria, Australia",
                "-37.787090","145.308273");
        DB.insert("Emporium Melbourne", "Rating: 4.4/5",
                "Contemporary shopping mall offering a variety of upscale retailers, plus restaurants & a food court.",
                "-37.815338","-37.815338");
        DB.insert("Crowne Plaza Melbourne", "Rating: 4.3/5",
                "With a California-inspired design that’s fresh and bright and a vibe that’s relaxed and cosy.",
                "-37.985950","145.215424");
        DB.insert("DoubleTree by Hilton Hotel", "Rating: 4.3/5",
                "boasts a resort-style setting overlooking the white sands of the Atlantic Ocean",
                "-37.817830","144.965410");
        DB.insert("Sydney Opera House", "Rating: 4.7/5",
                "The Sydney Opera House is a multi-venue performing arts centre at Sydney Harbour in Sydney, New South Wales, Australia. ",
                "-33.856785","151.215302");
        DB.insert("Sydney Harbour Bridge", "Rating: 4.7/5",
                "The Sydney Harbour Bridge is an Australian heritage-listed steel through arch bridge across Sydney Harbour " +
                        "that carries rail, vehicular, bicycle, and pedestrian traffic between the Sydney central business district and the North Shore.",
                "-33.852306","151.210785");
        DB.insert("Darling Harbour", "Rating: 4.7/5", "Darling Harbour is a harbour adjacent to the city centre of Sydney, " +
                        "New South Wales, Australia that is made up of a large recreational and pedestrian precinct that is situated on western outskirts of the Sydney central business district.",
                "-33.869919","151.198273");
        DB.insert("Aria Restaurant", "Rating: 4.3/5",
                "Chef Matt Moran presents Modern Australian haute cuisine in an elegant, glass-walled dining room.",
                "-33.896810","151.152120");
        DB.insert("360 Bar and Dining", "Rating: 4.3/5",
                "Revolving restaurant in dark mahogany for cocktails, grills and sweeping views of the city skyline.",
                "-33.872360","151.209280");
        DB.insert("Westfield Sydney", "Rating: 4.4/5",
                "A shopping centre operated by Scentre Group and located beneath the Sydney Tower and Myer department store, in the Sydney central business district. ",
                "-33.924721","151.115387");
        DB.insert("Harbourside", "Rating: 4.4/5",
                "A large-scale shopping centre in Darling Harbour, close to the Sydney central business district in Australia.",
                "-33.872760","151.205340");
        DB.insert("Four Seasons Hotel", "Rating: 4.3/5",
                "Overlooking Sydney Harbour and its iconic bridge, this luxe high-rise hotel is 1.4 km from Sydney Opera House.",
                "-33.861691","151.207687");
        DB.insert("Brandenburg Gate", "Rating: 4.7/5",
                "The Brandenburg Gate is an 18th-century neoclassical monument in Berlin, built on the orders of Prussian king Frederick William II after the temporary restoration of order during the Batavian Revolution.",
                "52.515869","13.378940");
        DB.insert("East Side Gallery", "Rating: 4.7/5",
                "The East Side Gallery is an open-air gallery in Berlin. It consists of a series of murals painted directly on a 1,316 m " +
                        "long remnant of the Berlin Wall, located near the centre of Berlin",
                "52.504951","52.504951");
        DB.insert("House of Small Wonder", "Rating: 4.3/5",
                "House of Small Wonder is a whimsical cafe known for its comfort food with Japanese influences.",
                "52.524529", "13.388960");
        DB.insert("A Mano", "Rating: 4.3/5",
                "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.",
                "52.524529","13.388960");
        DB.insert("Kaufhaus des Westens", "Rating: 4.4/5",
                "rThe Kaufhaus des Westens, usually abbreviated to KaDeWe, is a department store in Berlin. With over 60,000 square metres of selling space and more than 380,000 articles available," +
                        " it is the second largest department store in Europe after Harrods in London",
                "48.621050","7.488790");
        DB.insert("Westlin Grand Berlin", "Rating: 4.3/5",
                "A 10-minute walk from Brandenburg Gate at Großer Tiergarten (Berlin's oldest park), this grand, " +
                        "beaux arts-style hotel with a 30-meter atrium lobby is a 4-minute walk from the Gendarmenmarkt",
                "52.516190","13.388870");
        DB.insert("Palmengarten", "Rating: 4.7/5",
                "The Palmengarten is one of three botanical gardens in Frankfurt am Main, Germany. " +
                        "It is located in the Westend-Süd district. It covers a surface of 22 hectares.",
                "49.448132","8.352830");
        DB.insert("Romerberg", "Rating: 4.7/5",
                "Römerberg is a public space in Frankfurt, Germany. It is located in front of the Römer building complex, " +
                        "seat of the Frankfurt city administration since the 15th century.",
                "49.289320","8.401280");
        DB.insert("Kabuki", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.",
                "52.523430","13.411440");
        DB.insert("Skyline Plaza", "Rating: 4.4/5", "Shopping mall in Frankfurt, Germany",
                "50.109330","8.654770");
        DB.insert("Kabuki Hotel", "Rating: 4.3/5", "Hotel is in the city center and on the riverwalk.",
                "50.109330","8.654770");
        DB.insert("Casino Monte-Carlo", "Rating: 4.7/5",
                "a gambling and entertainment complex located in Monaco. " +
                        "It includes a casino, the Opéra de Monte-Carlo, and the office of Les Ballets de Monte-Carlo.",
                "43.739288","7.427270");
        DB.insert("Prince's Palance of Monaco", "Rating: 4.7/5",
                "he official residence of the Sovereign Prince of Monaco. Built in 1191 as a Genoese fortress, " +
                        "during its long and often dramatic history it has been bombarded and besieged by many foreign powers.",
                "43.732510","7.419040");
        DB.insert("Blue Bay", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.",
                "43.732510","7.419040");
        DB.insert("Huit & Demi", "Rating: 4.3/5",
                "Upscale shopping center with a luxurious feel, including marble floors & a crystal chandelier.",
                "43.73251","7.419040");
        DB.insert("Metropole Shopping Monte-Carlo", "Rating: 4.4/5",
                "Upscale shopping center with a luxurious feel, including marble floors & a crystal chandelier.",
                "43.73251","7.419040");
        DB.insert("Kimpton Hotel", "Rating: 4.3/5",
                "Upscale Hotel","43.73251","7.419040");
        DB.insert("Eiffel Tower", "Rating: 4.7/5",
                "a wrought-iron lattice tower on the Champ de Mars in Paris, France. " +
                        "It is named after the engineer Gustave Eiffel, whose company designed and built the tower.",
                "48.858372","2.294481");
        DB.insert("Louvre Museum", "Rating: 4.7/5",
                "the world's largest art museum and a historic monument in Paris, France. A central landmark of the city, " +
                        "it is located on the Right Bank of the Seine in the city's 1st arrondissement.",
                "48.866291","2.343610");
        DB.insert("Epicure", "Rating: 4.3/5",
                "Celebrated Three-Michelin-Star chef Eric Frechon, has created a temple of gastronomy that people travel to Paris to experience",
                "48.856890","2.350850");
        DB.insert("Guy Savoy", "Rating: 4.3/5",
                "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.",
                "48.856998","2.338700");
        DB.insert("Restaurant Kei", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.",
                "48.864330","2.342150");
        DB.insert("Italie Deux", "Rating: 4.4/5",
                "arge shopping centre in Paris' south east in the 13th arrondissement. " +
                        "It features a Printemps, fnac and over 130 stores, most of which are based overseas.",
                "48.827800","2.342150");
        DB.insert("Passage de Havre", "Rating: 4.4/5",
                "Passage du Havre is one of the covered passages of Paris. Formerly geared towards " +
                        "fish shops and railway modelling, the arcade was rebuilt in the late 1990s as a modern mall",
                "48.875500","2.342150");
        DB.insert("Holiday Inn", "Rating: 4.3/5", "Holiday Hotel is in the city center and on the riverwalk.",
                "48.875500","2.342150");
        DB.insert("Lafayette", "Rating: 4.3/5",
                "Lafayette is an upmarket French department store chain. " +
                        "Its flagship store is on Boulevard Haussmann in the 9th arrondissement of Paris",
                "48.875500","2.342150");
        DB.insert("Lowdermilk Park", "Rating: 4.7/5",
                "A public beach & park with outdoor showers, " +
                        "a concession stand, volleyball courts & a gazebo.",
                "40.835460", "14.248270");
        DB.insert("Naples Beach", "Rating: 4.7/5",
                "Seven-mile, white-sand beach along the turquoise gulf with a serene atmosphere & a fishing pier",
                "40.802240","14.184500");
        DB.insert("Truluck's", "Rating: 4.3/5",
                "Upscale seafood & steak chain featuring half-price happy hours, a deep wine list & swanky surrounds.",
                "40.899290", "14.344990");
        DB.insert("Waterside Shops", "Rating: 4.4/5",
                "The Waterside Shops is an open-air mall ", "40.842990","14.302880");
        DB.insert("Tin City Waterfront Shops", "Rating: 4.4/5",
                " It is open-air, specializing in antiques and local handmade novelties. There are four separate buildings. " +
                        "You can buy food, antiques, clothes, seashells, candles, wine, mood rings, and much more.",
                "40.846870","14.267510");
        DB.insert("Hilton Naples", "Rating: 4.3/5", "Hilton Naples is in the city center and on the riverwalk.",
                "40.851790","14.271370");
        DB.insert("The Naples Beach Hotel & Golf Club", "Rating: 4.3/5",
                "Dating to the Victorian era, this beachfront hotel set in 6 buildings is 2 miles from Downtown",
                "40.851790", "14.271370");
        DB.insert("Duomo di Milano", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia"
                , "40.851790","14.271370");
        DB.insert("Sforzesco Castle", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia" , "40.851790","14.271370");
        DB.insert("Galleria Vittorio Emanuele II", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia", "40.851790","14.271370");
        DB.insert("Seta", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "40.851790","14.271370");
        DB.insert("Niko Romito Space Milan", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "40.851790","14.271370");
        DB.insert("Galleria Vittorio Emanuele II", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.", "40.851790","14.271370");
        DB.insert("Hyatt Centric Milan Centrale", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "40.851790","14.271370");
        DB.insert("Radisson Blu Hotel", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "40.851790","14.271370");
        DB.insert("Colosseum", "Rating: 4.7/5", "an oval amphitheatre in the centre of the city of Rome, Italy", "40.851790","14.271370");
        DB.insert("Pantheon", "Rating: 4.7/5", "former Roman temple, now a Catholic church, in Rome, Italy, on the site of an earlier temple commissioned by Marcus Agrippa during the reign of Augustus", "40.851790","14.271370");
        DB.insert("Life Ristorante", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "40.851790","14.271370");
        DB.insert("Roscioli Salumeria con Cucina", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "40.851790","14.271370");
        DB.insert("Shopping Mall Porta di Roma", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street" +
                        " in the centre of Brisbane, Queensland, Australia.",
                "40.851790","14.271370");
        DB.insert("Galleria Alberto Sordi", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.", "40.851790","14.271370");
        DB.insert("Crowne Plaza Rome - St Peter's", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "40.851790","14.271370");
        DB.insert("Sheraton Roma Hotel", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "40.851790","14.271370");
        DB.insert("Miami Seaquarium", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia", "40.851790","14.271370");
        DB.insert("Santorini by Georgios", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "40.851790","14.271370");
        DB.insert("Michael's Genuine Food & Drink", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "40.851790","14.271370");
        DB.insert("Bayside Marketplace", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.", "40.851790","14.271370");
        DB.insert("Embassy Suites", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "40.851790","14.271370");
        DB.insert("Courtyard", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "40.851790","14.271370");
        DB.insert("Disneyland", "Rating: 4.7/5", "a collection of adventures, rides, and shows symbolized by the Disney characters and Sleeping Beauty Castle.", "40.851790","14.271370");
        DB.insert("Hollywood Studios", "Rating: 4.7/5", "a film studio and theme park in the San Fernando Valley area of Los Angeles County, California", "40.851790","14.271370");
        DB.insert("Roscoe's Chicken & Waffles", "Rating: 4.3/5", "Los Angeles-based soul food restaurant chain founded by Herb Hudson in 1975.", "40.851790","14.271370");
        DB.insert("The Grove", "Rating: 4.4/5", "The Grove is a retail and entertainment complex in Los Angeles, located on parts of the historic Farmers Market.", "40.851790","14.271370");
        DB.insert("FIGat7th", "Rating: 4.4/5", "FIGat7th is an open-air shopping mall located in the Financial District of Downtown Los Angeles", "40.851790","14.271370");
        DB.insert("Beverly Center", "Rating: 4.4/5", "shopping mall in Los Angeles, California, United States", "40.851790","14.271370");
        DB.insert("Freehand", "Rating: 4.3/5", "Housed in the historic Commercial Exchange building, our hotel in downtown Los Angeles is truly one-of-a-kind, featuring suites, premium hotel rooms", "40.851790","14.271370");
        DB.insert("Hilton Los Angeles Airport", "Rating: 4.3/5", "Enjoyable place to stay", "40.851790","14.271370");
        DB.insert("Statue of Liberty", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia", "40.851790","14.271370");
        DB.insert("Brooklyn Bridge", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia", "40.851790","14.271370");
        DB.insert("Gramercy Tavern", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "40.851790","14.271370");
        DB.insert("La Bernardin", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "40.851790","14.271370");
        DB.insert("Manhattan Mall", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.", "40.851790","14.271370");
        DB.insert("Brookfield Place", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.", "40.851790","14.271370");
        DB.insert("The Roosevelt Hotel", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "40.851790","14.271370");
        DB.insert("Fairfield Inn & Suites", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "40.851790","14.271370");
        //SF
        DB.insert("Golden Gate Bridge", "Rating: 4.7/5",
                "a suspension bridge spanning the Golden Gate, " +
                        "the one-mile-wide strait connecting San Francisco Bay and the Pacific Ocean.",
                "37.819927","-122.478255");
        DB.insert("Alcatraz", "Rating: 4.3/5",
                "Alcatraz Island is located in San Francisco Bay, 1.25 miles offshore from San Francisco, California, United States. " +
                        "The small island was developed with facilities for a lighthouse, a military fortification, a military prison, and a federal prison from 1934 until 21 March 1963.",
                "37.826099","-122.422101");
        DB.insert("Rich Table", "Rating: 4.4/5",
                "Californian fare from local ingredients, served in a salvaged-barn-wood space with an open kitchen.",
                "37.774872", "-122.422813");
        DB.insert("Quince", "Rating: 4.4/5",
                "Celebrated, upscale destination delivering seasonal, locally sourced cuisine & wines.",
                "37.797501","-122.403374");
        DB.insert("Westfield San Fransisco Centre", "Rating: 4.3/5",
                "9-story mall featuring over 170 shops & restaurants, a multiplex & a dome-covered atrium.",
                "37.784382", "-122.406326");
        DB.insert("Japan Center", "Rating: 4.3/5",
                "The Japan Center is a shopping center in the Japantown neighborhood of San Francisco, California. It opened in March 1968 and was originally called the Japanese Cultural and Trade Center.",
                "37.785381","-122.430344");
        DB.insert("Hilton SF Financial District", "Rating: 4.3/5",
                "Hotel details" +
                        "Located in San Francisco's financial district, this upscale 27-story hotel is a 1-mile drive from conventions at the Moscone Center",
                "37.795150","-122.404160");
        DB.insert("Marriot Marquis", "Rating: 4.3/5",
                "Set in a striking high-rise building, this polished downtown hotel " +
                        "is within a 4-minute walk of the Powell Street BART",
                "37.785049","-122.404099");

        //Barcelona
        DB.insert("La Sagrada Familia", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia", "41.397634","2.149757");
        DB.insert("Park Guell", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "41.397634","2.149757");
        DB.insert("Casa Mila", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.", "41.397634","2.149757");
        DB.insert("Viana Barcelona", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");
        DB.insert("Disfrutar Barcelona", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");
        DB.insert("Maremagnum", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");
        DB.insert("Diagonal Mar", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");
        DB.insert("Hotel SB Diagonal Zero Barcelona", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");
        DB.insert("W Barcelona", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");

        //Madrid
        DB.insert("Plaza Mayor", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia", "41.397634","2.149757");
        DB.insert("El Retiro Park", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "41.397634","2.149757");
        DB.insert("CEBO Madrid Restaurant", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.", "41.397634","2.149757");
        DB.insert("Centro Commercial La Vaguada", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");
        DB.insert("Plenilunio", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");
        DB.insert("Madrid Marriott Auditorium", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");

        //Seville
        DB.insert("Plaza De Espana", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia", "41.397634","2.149757");
        DB.insert("La Giralda", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "41.397634","2.149757");
        DB.insert("Al Wadi", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.", "41.397634","2.149757");
        DB.insert("Los Arcos", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");
        DB.insert("Nervion Plaza", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");
        DB.insert("Hotel Alfonso XIII", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "41.397634","2.149757");

        //Moscow
        DB.insert("Red Square", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia", "55.777152","37.604197");
        DB.insert("St Basil's Cathedral", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "55.777152","37.604197");
        DB.insert("Sempre Moscow", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.", "55.777152","37.604197");
        DB.insert("Mari Vanna", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.", "55.777152","37.604197");
        DB.insert("Aviapark", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "55.777152","37.604197");
        DB.insert("Okhotny Ryad", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "55.777152","37.604197");
        DB.insert("Moscow Marriott Grand Hotel", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "55.777152","37.604197");

        //St. Petersburg
        DB.insert("Peterhof", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia" ,"59.960510", "30.316481");
        DB.insert("State Hermitage Museum", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.","59.960510", "30.316481");
        DB.insert("Yat'", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.","59.960510", "30.316481");
        DB.insert("Palkin", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.","59.960510", "30.316481");
        DB.insert("Galleria Shopping Mall", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.","59.960510", "30.316481");
        DB.insert("Nevsky Centre", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.","59.960510", "30.316481");
        DB.insert("Saint Petersburg", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.","59.960510", "30.316481");
        DB.insert("Courtyard", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.","59.960510", "30.316481");

        //Munich
        DB.insert("Marienplatz", "Rating: 4.7/5", "a cultural, social, educational and recreational precinct in Brisbane, Queensland, Australia", "48.153031", "11.566254");
        DB.insert("English Garden", "Rating: 4.3/5", "Breezy waterfront restaurant with outdoor seating, inventive cocktails and creative global cuisine.", "48.153031", "11.566254");
        DB.insert("Resaurant Savanna Munich", "Rating: 4.4/5", "The Queen Street Mall is a pedestrian mall located on Queen Street in the centre of Brisbane, Queensland, Australia.", "48.153031", "11.566254");
        DB.insert("Olympia-Einkaufszentrum", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "48.153031", "11.566254");
        DB.insert("Hilton Munich City", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "48.153031", "11.566254");
        DB.insert("Aloft Munich", "Rating: 4.3/5", "Brisbane Marriott Hotel is in the city center and on the riverwalk.", "48.153031", "11.566254");





        text = findViewById(R.id.textView22);
        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
            TourName = mBundle.getString("TourName");
        }
        Cursor c = DB.getPlace(TourName);
        if(c == null) {
            Toast.makeText(getApplicationContext(),"Null", Toast.LENGTH_LONG).show();
        }
        else {
            nameOfPlace  = c.getString(c.getColumnIndex(PlacesDB.FIELD_NAME));
            ratingOfPlace = c.getString(c.getColumnIndex(PlacesDB.FIELD_RATINGS));
            DescriptionOfPlace = c.getString(c.getColumnIndex(PlacesDB.FIELD_DESCRIPTION));
            latitude = c.getDouble(c.getColumnIndex(PlacesDB.FIELD_LAT));
            longitude = c.getDouble(c.getColumnIndex(PlacesDB.FIELD_LONG));

        }
        NameText.setText(nameOfPlace);
        text.setText(DescriptionOfPlace);
        ratingText.setText(ratingOfPlace);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(getApplicationContext(), MapsActivity.class);
                mapIntent.putExtra("lat", latitude);
                mapIntent.putExtra("long", longitude);
                mapIntent.putExtra("name", nameOfPlace);
                startActivity(mapIntent);

            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/search?q="+nameOfPlace);
                Intent gSearchIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(gSearchIntent);
            }
        });
    }
}