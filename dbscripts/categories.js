var BuySell =  db.getSiblingDB('BuySell');
var category =[
{ 
   
	"_id" : "KITCHEN", 
    "subCategories" : [
        "utensils", 
        "cylinder", 
        "Rice Cooker"
    ]}

{"_id" : "MOBILES & TABLETS", 
"subCategories" : [
    "Mobile Phones", 
    "Tablets", 
    "Accessories"
]}

{ "_id" : "ELECTRONICS", 
    "subCategories" : [
        "Computers",
        "Laptops", 
        "CDs-DVDs",
        "Cameras",
        "Video Games",
        "TV",
        "Other Electroncis"
    ]
}


{"_id" : "VEHICLES", 
    "subCategories" : [
        "Cars",
        "Motorcycles", 
        "Scooters",
        "Bicycles",
        "Commercial Vehicles",
        "Spare Parts",
        "Other Vehicles"
     
    ]}

{"_id" : "FURNITURE", 
    "subCategories" : [
        "Furniture",
        "Decor & Furnishing", 
        
    ]}

{"_id" : "ANIMALS", 
    "subCategories" : [
        "Dogs",
        "Aquariums", 
        "Birds",
        "Cats",
        "Other Animals"
    ]}


{"_id" : "BOOKS", 
    "subCategories" : [
        "Books & Magazines",
        "Musical Instruments", 
        "Sports Equpiment"
    ]}

{"_id" : "FASHION & BEAUTY", 
    "subCategories" : [
        "Clothes",
        "Footwear", 
        "Jewellery",
        "Bags & Luggage"
        "Watches",
        "Health & Beauty"
    ]}

{"_id" : "KIDS PRODUCTS", 
    "subCategories" : [
        "Strollers",
        "Kids Furniture", 
        "Car Seats",
        "Nutrition",
        "Clothes & Footwear",
       "Toys & Games",
       "Other Kids Items"
    ]}

{"_id" : "SERVICES", 
    "subCategories" : [
        "Education & Classes",
        "Web Development",
        "Electronics & Computer Repair", 
        "Maids & Demostic Help",
        "Health & Beauty",
        "Drivers & Taxi",
        "Event Services",
        "Other Services"
    ]}

{"_id" : "JOBS",
    "subCategories" : [
        "Customer Service",
        "IT", 
        "Online",
        "Marketing",
        "Sales",
        "Clerical Administration",
        "Human Resources",
        "Education",
        "Hotels & Tourism",
        "Accounting & Finance",
        "Manufacturing",
        "Part-Time",
        "Other Jobs"
    ]}
{"_id" : "REAL ESTATE", 
    "subCategories" : [
        "Houses",
        "Apartments", 
        "PG & Roommates",
        "Land & Plots",
        "Shops-Offices-Commercial Space",
        "Vacation Rentals & Guest Houses"
    ]}

{"_id" : "HOME NEEDS", 
    "subCategories" : [
        "Fridge-AC-Washing machine",
        "Home & Kitchen Appliances", 
        "Other Household Items"
    ]}]

BuySell.category.save(category);