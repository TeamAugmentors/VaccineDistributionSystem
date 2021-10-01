CREATE DATABASE VaccinationCenter
DROP DATABASE VaccinationCenter

DROP TABLE IF EXISTS DISTRIBUTION_CENTER;
DROP TABLE IF EXISTS PERSON;
DROP TABLE IF EXISTS VACCINATION_CENTER;
DROP TABLE IF EXISTS COVID_AFFECTED ;
DROP TABLE IF EXISTS VACCINE;
DROP TABLE IF EXISTS STORAGE;
DROP TABLE IF EXISTS ADMIN_PANEL;
DROP TABLE IF EXISTS INFORMATION;
DROP TABLE IF EXISTS IDENTIFIER_INFORMATION;

------> Table Informations
CREATE TABLE IDENTIFIER_INFORMATION (
	Identifier varchar(17) PRIMARY KEY NOT NULL,
	FullName varchar(255) NOT NULL,
	Gender char NOT NULL
)

SELECT TOP 1000 * FROM IDENTIFIER_INFORMATION

INSERT INTO IDENTIFIER_INFORMATION VALUES 
('121434334', 'Ruhid mashuurf', 'M'),
('121433034', 'Jongi Bhairun' , 'M'),
('122734334', 'Gabiru', 'M'),
('12164334', 'Ineza', 'M'),
('1234', 'Riskkara', 'M'),
('1000000000', 'Sanjid Islam Chowhudry', 'M'),
('1000000001', 'Atikur Rahman', 'M'),
('1000000002', 'Ahmed tanim', 'M'),
('1000000003', 'Rishtat Ranzim', 'M'),
('10248','Wilman Kala', 'F'),
('10249','Tradição Hipermercados', 'F'),
('10250','Hanari Carnes', 'F'),
('10251','Victuailles en stock', 'F'),
('10252','Suprêmes délices', 'F'),
('10253','Hanari Carnes', 'F'),
('10254','Chop-suey Chinese', 'F'),
('10255','Richter Supermarkt', 'F'),
('10256','Wellington Importadora', 'F'),
('10257','HILARIÓN-Abastos', 'F'),
('10258','Ernst Handel', 'F'),
('10259','Centro comercial Moctezuma', 'M'),
('10260','Old World Delicatessen', 'M'),
('10261','Que Delícia', 'M'),
('10262','Rattlesnake Canyon Grocery', 'M'),
('10263','Ernst Handel', 'M'),
('10264','Folk och fä HB', 'M'),
('10265','Blondel père et fils', 'M'),
('10266','Wartian Herkku', 'M'),
('10267','Frankenversand', 'M'),
('10268','GROSELLA-Restaurante', 'M'),
('10269','White Clover Markets', 'F'),
('10270','Wartian Herkku', 'F'),
('10271','Split Rail Beer & Ale', 'F'),
('10272','Rattlesnake Canyon Grocery', 'F'),
('10273','QUICK-Stop', 'F'),
('10274','Vins et alcools Chevalier', 'F'),
('10275','Magazzini Alimentari Riuniti', 'F'),
('10276','Tortuga Restaurante', 'F'),
('10277','Morgenstern Gesundkost', 'F'),
('10278','Berglunds snabbköp', 'F'),
('10279','Lehmanns Marktstand', 'F'),
('10280','Berglunds snabbköp', 'F'),
('10281','Romero y tomillo', 'F'),
('10282','Romero y tomillo', 'F'),
('10283','LILA-Supermercado', 'F'),
('10284','Lehmanns Marktstand', 'F'),
('10285','QUICK-Stop', 'F'),
('10286','QUICK-Stop', 'F'),
('10287','Ricardo Adocicados', 'F'),
('10288','Reggiani Caseifici', 'F'),
('10289','Bs Beverages', 'F'),
('10290','Comércio Mineiro', 'F'),
('10291','Que Delícia', 'F'),
('10292','Tradição Hipermercados', 'F'),
('10293','Tortuga Restaurante', 'F'),
('10294','Rattlesnake Canyon Grocery', 'F'),
('10295','Vins et alcools Chevalier', 'F'),
('10296','LILA-Supermercado', 'F'),
('10297','Blondel père et fils', 'F'),
('10298','Hungry Owl All-Night Grocers', 'F'),
('10299','Ricardo Adocicados', 'F'),
('10300','Magazzini Alimentari Riuniti', 'F'),
('10301','Die Wandernde Kuh', 'F'),
('10302','Suprêmes délices', 'F'),
('10303','Godos Cocina Típica', 'F'),
('10304','Tortuga Restaurante', 'F'),
('10305','Old World Delicatessen', 'F'),
('10306','Romero y tomillo', 'F'),
('10307','Lonesome Pine Restaurant', 'F'),
('10308','Ana Trujillo Emparedados y helados', 'F'),
('10309','Hungry Owl All-Night Grocers', 'F'),
('10310','The Big Cheese', 'F'),
('10311','Du monde entier', 'F'),
('10312','Die Wandernde Kuh', 'F'),
('10313','QUICK-Stop', 'F'),
('10314','Rattlesnake Canyon Grocery', 'M'),
('10315','Island Trading', 'M'),
('10316','Rattlesnake Canyon Grocery', 'M'),
('10317','Lonesome Pine Restaurant		   ', 'M'),
('10318','Island Trading					   ', 'M'),
('10319','Tortuga Restaurante			   ', 'M'),
('10320','Wartian Herkku					   ', 'M'),
('10321','Island Trading					   ', 'M'),
('10322','Pericles Comidas clásicas		   ', 'M'),
('10323','Königlich Essen				   ', 'M'),
('10324','Save-a-lot Markets				   ', 'M'),
('10325','Königlich Essen				   ', 'M'),
('10326','Bólido Comidas preparadas		   ', 'M'),
('10327','Folk och fä HB					   ', 'M'),
('10328','Furia Bacalhau e Frutos do Mar	   ', 'M'),
('10329','Split Rail Beer & Ale			   ', 'M'),
('10330','LILA-Supermercado				   ', 'M'),
('10331','Bon app						   ', 'M'),
('10332','Mère Paillarde					   ', 'M'),
('10333','Wartian Herkku					   ', 'M'),
('10334','Victuailles en stock			   ', 'M'),
('10335','Hungry Owl All-Night Grocers	   ', 'M'),
('10336','Princesa Isabel Vinhoss		   ', 'M'),
('10337','Frankenversand					   ', 'M'),
('10338','Old World Delicatessen			   ', 'M'),
('10339','Mère Paillarde					   ', 'M'),
('10340','Bon app						   ', 'M'),
('10341','Simons bistro					   ', 'M'),
('10342','Frankenversand					   ', 'M'),
('10343','Lehmanns Marktstand			   ', 'M'),
('10344','White Clover Markets			   ', 'M'),
('10345','QUICK-Stop						   ', 'M'),
('10346','Rattlesnake Canyon Grocery		   ', 'M'),
('10347','Familia Arquibaldo				   ', 'M'),
('10348','Die Wandernde Kuh				   ', 'M'),
('10349','Split Rail Beer & Ale			   ', 'M'),
('10350','La maison dAsie				   ', 'M'),
('10351','Ernst Handel					   ', 'M'),
('10352','Furia Bacalhau e Frutos do Mar	   ', 'M'),
('10353','Piccolo und mehr				   ', 'M'),
('10354','Pericles Comidas clásicas		   ', 'M'),
('10355','Around the Horn				   ', 'M'),
('10356','Die Wandernde Kuh				   ', 'M'),
('10357','LILA-Supermercado				   ', 'M'),
('10358','La maison dAsie				   ', 'M'),
('10359','Seven Seas Imports				   ', 'M'),
('10360','Blondel père et fils			   ', 'M'),
('10361','QUICK-Stop						   ', 'M'),
('10362','Bon app						   ', 'M'),
('10363','Drachenblut Delikatessend		   ', 'M'),
('10364','Eastern Connection				   ', 'M'),
('10365','Antonio Moreno Taquería		   ', 'M'),
('10366','Galería del gastrónomo			   ', 'M'),
('10367','Vaffeljernet					   ', 'M'),
('10368','Ernst Handel					   ', 'M'),
('10369','Split Rail Beer & Ale			   ', 'M'),
('10370','Chop-suey Chinese				   ', 'M'),
('10371','La maison dAsie				   ', 'M'),
('10372','Queen Cozinha					   ', 'M'),
('10373','Hungry Owl All-Night Grocers	   ', 'M'),
('10374','Wolski							   ', 'M'),
('10375','Hungry Coyote Import Store		   ', 'M'),
('10376','Mère Paillarde					   ', 'M'),
('10377','Seven Seas Imports				   ', 'M'),
('10378','Folk och fä HB					   ', 'M'),
('10379','Que Delícia					   ', 'M'),
('10380','Hungry Owl All-Night Grocers	   ', 'M'),
('10381','LILA-Supermercado				   ', 'M'),
('10382','Ernst Handel					   ', 'M'),
('10383','Around the Horn				   ', 'M'),
('10384','Berglunds snabbköp				   ', 'M'),
('10385','Split Rail Beer & Ale			   ', 'M'),
('10386','Familia Arquibaldo				   ', 'M'),
('10387','Santé Gourmet					   ', 'M'),
('10388','Seven Seas Imports				   ', 'M'),
('10389','Bottom-Dollar Marketse			   ', 'M'),
('10390','Ernst Handel					   ', 'M'),
('10391','Drachenblut Delikatessend		   ', 'M'),
('10392','Piccolo und mehr				   ', 'M'),
('10393','Save-a-lot Markets				   ', 'M'),
('10394','Hungry Coyote Import Store		   ', 'M'),
('10395','HILARIÓN-Abastos				   ', 'M'),
('10396','Frankenversand					   ', 'M'),
('10397','Princesa Isabel Vinhoss		   ', 'M'),
('10398','Save-a-lot Markets				   ', 'M'),
('10399','Vaffeljernet					   ', 'M'),
('10400','Eastern Connection				   ', 'M'),
('10401','Rattlesnake Canyon Grocery		   ', 'M'),
('10402','Ernst Handel					   ', 'M'),
('10403','Ernst Handel					   ', 'M'),
('10404','Magazzini Alimentari Riuniti	   ', 'M'),
('10405','LINO-Delicateses				   ', 'M'),
('10406','Queen Cozinha					   ', 'M'),
('10407','Ottilies Käseladen				   ', 'M'),
('10408','Folies gourmandes				   ', 'M'),
('10409','Océano Atlántico Ltda.			   ', 'M'),
('10410','Bottom-Dollar Marketse			   ', 'M'),
('10411','Bottom-Dollar Marketse			   ', 'M'),
('10412','Wartian Herkku					   ', 'M'),
('10413','La maison dAsie				   ', 'M'),
('10414','Familia Arquibaldo				   ', 'M'),
('10415','Hungry Coyote Import Store		   ', 'M'),
('10416','Wartian Herkku					   ', 'M'),
('10417','Simons bistro					   ', 'M'),
('10418','QUICK-Stop						   ', 'M'),
('10419','Richter Supermarkt				   ', 'M'),
('10420','Wellington Importadora			   ', 'M'),
('10421','Que Delícia					   ', 'M'),
('10422','Franchi S.p.A.					   ', 'M'),
('10423','Gourmet Lanchonetes			   ', 'M'),
('10424','Mère Paillarde					   ', 'M'),
('10425','La maison dAsie				   ', 'M'),
('10426','Galería del gastrónomo			   ', 'M'),
('10427','Piccolo und mehr				   ', 'M'),
('10428','Reggiani Caseifici				   ', 'M'),
('10429','Hungry Owl All-Night Grocers	   ', 'M'),
('10430','Ernst Handel					   ', 'M'),
('10431','Bottom-Dollar Marketse			   ', 'M'),
('10432','Split Rail Beer & Ale			   ', 'M'),
('10433','Princesa Isabel Vinhoss		   ', 'M'),
('10434','Folk och fä HB					   ', 'M'),
('10435','Consolidated Holdings			   ', 'M'),
('10436','Blondel père et fils			   ', 'M'),
('10437','Wartian Herkku					   ', 'F'),
('10438','Toms Spezialitäten				   ', 'F'),
('10439','Mère Paillarde					   ', 'F'),
('10440','Save-a-lot Markets				   ', 'F'),
('10441','Old World Delicatessen			   ', 'F'),
('10442','Ernst Handel					   ', 'F'),
('10443','Reggiani Caseifici                ', 'F')

CREATE TABLE ADMIN_PANEL (
	ID INT IDENTITY(1 ,1) PRIMARY KEY NOT NULL,
	FirstName varchar(50) NOT NULL,
	LastName varchar(50) NOT NULL,
	Username varchar(50) NOT NULL,
	PasswordHash varchar(28) NOT NULL
)	

SELECT * FROM ADMIN_PANEL

INSERT INTO ADMIN_PANEL VALUES ('Sanjid', 'Chowdhury', 'Lassassin', '123456'),
							   ('Atikur', 'Rahman', 'Atiq', '123456'),
							   ('Tanim', 'Ahmed', 'A.S.T.', '123456')

CREATE TABLE DISTRIBUTION_CENTER 
(
Vaccine_Brand VARCHAR(45) NOT NULL PRIMARY KEY,
IsApproved INT NOT NULL,
IsDeployed INT NOT NULL,
Amount_Ordered INT,
Amount_Recieved INTEGER,
Gift_Received_Amount INT,
Total_Amount INT,
Amount_Administered INT
);

SELECT * FROM DISTRIBUTION_CENTER

INSERT INTO DISTRIBUTION_CENTER VALUES('Pfizer', 1, 1, 13100000, 3600000, 3600000, 360000, 147073),
									  ('AstraZeneca', 1, 1, 35700000, 7000000, 6500000, 13500000, 12800000),
									  ('Sputnik V', 1, 0, 40000000, NULL, NULL, NULL, NULL),
									  ('Sinopharm', 1, 1, 75000000, 29000000,  5500000, 34500000, 22800000),
									  ('Sinovac', 1, 0, NULL, NULL,  NULL, NULL, NULL),
									  ('Janssen', 1, 0, NULL, NULL, NULL, NULL, NULL),
									  ('Morderna', 1, 1, 7300000, 5500000,  5500000, 5500000, 510000)


CREATE TABLE INFORMATION (
	City varchar(50) NOT NULL,
	Area TEXT NOT NULL
)

SELECT * FROM INFORMATION

INSERT INTO INFORMATION VALUES ('Dhaka', '"Abdullahpur", "Adabor", "Aftabnagar", "Agargaon", "Airport Area", "Armanitola", "Asad Gate", "Ashkona", "Azimpur", "Badda", "Baily Road", "Bakshi Bazar", "Banani", "Banani DOHS", "Banasree", "Bangabhaban", "Bangla Motor", "Bangshal", "Baridhara", "Baridhara DOHS", "Bashabo", "Bashundhara R/A", "Baunia", "Begom Bazar", "Begun Bari", "Bijoy Sarani", "Bijoynagar", "Bosila", "Cantonment", "Central Road", "Chawk Bazar", "College Gate", "Dakshin Khan", "Darussalam", "Demra", "Dhaka University Area", "Dhanmondi", "Dilkusha", "Dilu Road", "Doyagonj", "Eastern Housing", "Elephant Road", "English Road", "Faidabad", "Farmgate", "Fokirapul", "Gabtoli", "Gandaria", "Golapbag", "Gopibagh", "Goran", "Green Road", "Gulistan", "Gulshan-1", "Gulshan-2", "Hatirjheel", "Hatirpul", "Hazaribag", "Ibrahimpur", "Indira Road", "Jatrabari", "Jigatola", "Joar Shahara", "Joynag Road", "Jurain", "Kadamtoli", "Kafrul", "Kakrail", "Kalabagan", "Kalachandpur", "Kalshi", "Kamlapur", "Kamrangirchar", "Karwan Bazar", "Katabon", "Kathal Bagan", "Kawla", "Kazipara", "Keraniganj", "Khilgaon", "Khilkhet", "Kollanpur", "Kotwali", "Kuril", "Lake Circus Road", "Lalbag", "Lalmatia", "Luxmi Bazar", "Madartek", "Malibagh", "Maniknagar", "Matikata", "Matuail", "Meradia", "Mirpur 1", "Mirpur 2", "Mirpur 3", "Mirpur 6", "Mirpur 7", "Mirpur 10", "Mirpur 11", "Mirpur 12", "Mirpur 13", "Mirpur 14", "Mirpur Cantonment", "Mirpur DOHS", "Mitford Road", "Mogbazar", "Mohakhali", "Mohakhali DOHS", "Mohammadpur", "Mollartek", "Monipur", "Monipuri Para", "Motijheel", "Mouchak", "Mugda", "Nakhalpara", "Nandipara", "Narinda", "Natun Bazar", "Nawabpur", "Naya Bazar", "Naya Paltan", "New Eskaton Road", "New Market", "Niketon", "Nikunja-1", "Nikunja-2", "Nilkhet", "Nobabgonj", "Norda", "Pallabi", "Paltan", "Panthapath", "Paribag", "Pilkhana", "Pink City Model Town", "Pirerbag", "Polashi", "Postogola", "Puran Dhaka", "Purana Paltan", "Ramna", "Rampura", "Rayer Bazar", "Rayerbag", "Razarbagh", "Rupnagar", "Sabujbag", "Sadarghat", "Sankar", "Sayedabad", "Segunbagicha", "Shahbag", "Shahinbag", "Shahjadpur", "Shajahanpur", "Shantibag", "Shantinagar", "Shekhertek", "Shegunbagicha", "Sher-e-Bangla Nagor", "Shewrapara", "Shyamoli", "Shyampur", "Siddeshwari", "Sobahan Bag", "Sonir Akhra", "South Banasree", "Sukrabad", "Sutrapur", "Swamibagh", "Tejgaon", "Tejkunipara", "Tikatuli", "Tilpapara", "Turag", "Uttar Khan", "Uttara Sector 1", "Uttara Sector 2", "Uttara Sector 3", "Uttara Sector 4", "Uttara Sector 5", "Uttara Sector 6", "Uttara Sector 7", "Uttara Sector 8", "Uttara Sector 9", "Uttara Sector 10", "Uttara Sector 11", "Uttara Sector 12", "Uttara Sector 13", "Uttara Sector 14", "Uttara Sector 15", "Uttara Sector 16", "Uttara Sector 17", "Uttara Sector 18", "Vasantek", "Wari", "West Rampura", "Zigatola"'),
('Chittagong', '"2 No. Gate", "A.K Khan", "Agrabad", "Akbarshah Railway Colony", "Ali Nagar", "Alkaran", "Aman Bazar", "Amirbag", "Amtala", "Andarkilla", "Anwara", "Arakan H/S", "Arefin Nagar", "Ashkar Dighir Par", "Aturar Depo", "Badurtala", "Bahaddarhat", "Baitush Sharaf", "Bakalia", "Baluchara", "Banani R/A", "Bandar", "Bangladesh Bank Colony", "Batali Road", "Battery Goli", "Bayazid", "Bepari Para", "Bibirhat", "Bondor Tila", "Bow Bazar", "Boxirhat", "Burischar", "Burma Colony", "Cantonment", "CDA Residential Area", "Cement Crossing", "CEPZ", "Chaitanna Goli", "Chaktai", "Chandanaish", "Chandgaon R/A", "Chandrima", "Chasma Hill R/A", "Chatteswari Road", "Chawk Bazar", "Chowdhury Para", "Chowmuhani", "Cinema Palace", "City Gate", "CNB", "Colonel Hat", "Cosmopolitan R/A", "CRB Road", "D.T. Road", "Dampara", "Darogha Hat", "DC Road", "Debar Par", "Dewan Bazar", "Dewanhat", "Double Mooring", "Enayet Bazar", "Farider Para", "Fatehabad", "Firingi Bazar", "Firoz Shah Colony", "Free Port", "Gani Colony", "GEC Circle", "Gol Pahar Moor", "North Halishahar", "North-Middle Halishahar", "South Halishahar", "South-Middle Halishahar", "Hamjarbag", "Hashem Bazar", "Hathazari", "Hazipara", "Hill View R/A", "Ice Factory Road", "Ishan Mistrir Hat", "Jalalabad H/S", "Jamalkhan", "Jangalpara", "Jhawtola", "Jubilee Road", "Kadamtali", "Kafco Housing colony", "Kalamia Bazar", "Kalurghat", "Kamal Gate", "Kanon Dhara H/S", "Kapasgola", "Kaptai Rastar Matha", "Karnafuly", "Kata Pahar Lane", "Katalgonj R/A", "Kattali", "Kazir Dewri", "Khatiber Hat", "Khulshi Colony", "Khulshi R/A", "Kotwali", "Kulgaon", "Kunjachaya R/A", "Laldighir Par", "Lalkhan Bazar", "Love Lane", "M.M. Ali Road", "Madarbari", "Majhir Ghat", "Mehedibag", "Mirsharai", "Mistripara", "Mohammad Nagar", "Mohammadpur", "Momin Bagh", "Momin Road", "Monsurabad", "Mosjid Goli", "Moti Jharna", "Mozzaffarnagar", "Mousumi R/A", "Muradpur", "Nabi Nagar", "Nalapara", "Nandon Kanon", "Nasirabad", "Nazir Para", "Nazu Meah Hat", "New Market", "O.R. Nizam Road", "Oxygen", "Pahartali", "Panchlaish R/A", "Patenga", "Pathantuli", "Patharghata", "Polytechnic", "Port Colony", "Postarpar", "Probortok Circle", "Quaish", "Rahatarpul", "Rahman Nagar", "Rangunia", "Rose Valley R/A", "Ruby Gate", "Sabujbag", "Sagorika", "Santibag R/A", "Saraipara", "Sat Rastar Matha", "Shadarghat", "Shah Garibullah H/S", "Shamoli R/A", "Sheikh Mujib Road", "Shershah Colony", "Sholokbahar", "Sholoshohor", "Station Road", "Sugandha R/A", "Surson Road", "Tankey Pahar", "Tiger Pass", "Tin Puler Matha", "Urdo Road", "Wapda Colony", "Zakir Hossain Road"'),
('Khulna', '"Batighata", "Boyra Bazar", "Dacope", "Dakbangla", "Daulatpur", "Dighalia", "Dumuria", "Gollamari", "Keshabpur", "Khalishpur", "Khan Jahan Ali", "Khulna Sadar", "Koyla Ghat", "Koyra", "Lobon Chora", "Nirala", "Pabla", "Paikgachha", "Phultala", "Rayermohol", "Rupsa", "Sonadanga", "Terokhada", "Tootpara"'),
('Sylhet', '"Akhalia", "Amber Khana", "Bagh Bari", "Balaganj", "Bandar Bazar", "Beanibazar", "Bimanbondor", "Bishwanath", "Chouhatta", "Companiganj", "Dargah Mahalla", "Fenchuganj", "Golapganj", "Gowainghat", "Jaintapur", "Kajal Shah", "Kanaighat", "Kumar para", "Lama Bazar", "Majortila", "Nayasarak", "Osmani Nagar", "Pathan Tula", "Shahi Eidgah", "Shahporan", "Shibgonj", "South Surma", "Subhani Ghat", "Subid Bazar", "Uposhohor", "Zakiganj", "Zinda Bazar"'),
('Rajshahi', '"Aam Chattar", "Aambagan", "Ashrayan Project", "Bagmara", "Baharampur", "Basuri", "Binodpur", "Boalia", "Bornali Mor", "Boro Bongram", "Bosepara", "Budhpara", "Bullanpara", "Choto Bongram", "Chowddopai", "Court Station", "Daharampur", "Dashmari", "Dorga Para", "Godagari", "Haragram", "Hatemkha", "Hazrapukur", "Horogram", "Horogram Notunpara", "Hossainganj", "Kadirganj", "Katakhali", "Kathalbaria", "Kazihata", "Kazla", "Khojapur", "Luxmipur Mor", "Meher Chandi", "Methor Para", "Mirer Tek", "Mollapara", "Motihar", "New Market", "Nowdapara", "Padma Residential Area"'),
('Mymensingh', '"Cantonment", "Chorpara", "Ganginar Par", "Ishwarganj", "Kewatkhali", "Kistopur", "Muktagacha", "Naumahal", "Phulpur", "Town Hall", "Valuka"'),
('Barishal', '"Amtala", "Bakerganj", "Banglabazar", "Beltola Feri Ghat", "Chand mari", "Chawk Bazar", "City Gate (Gorierpar)", "Gournadi", "Kalizira", "Kashipur Bazar", "Launch Ghat", "Mehendiganj", "Natullabad", "Natun Bazar", "Nazirmoholla", "Nobogram Road", "Puran Bazar", "Rupatali", "Sadar Road", "Uttar Alekanda"'),
('Comilla', '"Amtoli", "Ashok Tala", "Badur Tola", "Bagan Bari", "Bagichagaon", "Baropara", "Biswa Road", "BSCIC", "Cantonment", "Chowk bazar", "Comilla Export Processing Zone", "Court Road", "Daulatpur", "DC Road", "Dhanmondi Road", "Dharmapur", "Dharmasagar Lake", "Dhulipara", "Digumbaritala", "Gobindapur", "Housing Estate", "Jangalia", "Jhakuni Para", "Jhautola", "Kaliajuri", "Kandirpar", "Kaptan Bazar", "Kotbari", "Kuchaituli", "Laksham Road", "Madina Masjid", "Manoharpur", "Mughal Toli", "Munsef Bari", "Nanua Dighir Par", "New Market", "North Chartha", "Nurpur", "Police Line", "Prince Road", "Race Course", "Chandrima", "Chasma Hill R/A", "Chatteswari Road", "Chawk Bazar", "Chowdhury Para", "Chowmuhani", "Cinema Palace", "City Gate", "CNB", "Colonel Hat", "Cosmopolitan R/A", "CRB Road", "D.T. Road", "Dampara", "Darogha Hat", "DC Road", "Debar Par", "Dewan Bazar", "Dewanhat", "Double Mooring", "Enayet Bazar", "Farider Para", "Fatehabad", "Firingi Bazar", "Firoz Shah Colony", "Free Port", "Gani Colony", "GEC Circle", "Gol Pahar Moor", "Halishahar", "Hamjarbag", "Hashem Bazar", "Hathazari", "Hazipara", "Hill View R/A", "Ice Factory Road", "Ishan Mistrir Hat", "Jalalabad H/S", "Jamalkhan", "Jangalpara", "Jhawtola", "Jubilee Road", "Kadamtali", "Kafco Housing colony", "Kalamia Bazar", "Kalurghat", "Kamal Gate", "Kanon Dhara H/S", "Kapasgola", "Kaptai Rastar Matha", "Karnafuly", "Kata Pahar Lane", "Katalgonj R/A", "Kattali", "Kazir Dewri", "Khatiber Hat", "Khulshi Colony", "Khulshi R/A", "Kotwali", "Kulgaon", "Kunjachaya R/A", "Laldighir Par", "Lalkhan Bazar", "Love Lane", "M.M. Ali Road", "Madarbari", "Majhir Ghat", "Mehedibag", "Mirsharai", "Mistripara", "Mohammad Nagar", "Mohammadpur", "Momin Bagh", "Momin Road", "Monsurabad", "Mosjid Goli", "Moti Jharna", "Mozzaffarnagar", "Mousumi R/A", "Muradpur", "Nabi Nagar", "Nalapara", "Nandon Kanon", "Nasirabad", "Nazir Para", "Nazu Meah Hat", "New Market", "O.R. Nizam Road", "Oxygen", "Pahartali", "Panchlaish R/A", "Patenga", "Pathantuli", "Patharghata", "Polytechnic", "Port Colony", "Postarpar", "Probortok Circle", "Quaish", "Rahatarpul", "Rahman Nagar", "Rangunia", "Rose Valley R/A", "Ruby Gate", "Sabujbag", "Sagorika", "Santibag R/A", "Saraipara", "Sat Rastar Matha", "Shadarghat", "Shah Garibullah H/S", "Shamoli R/A", "Sheikh Mujib Road", "Shershah Colony", "Sholokbahar", "Sholoshohor", "Station Road", "Sugandha R/A", "Surson Road", "Tankey Pahar", "Tiger Pass", "Tin Puler Matha", "Urdo Road", "Wapda Colony", "Zakir Hossain Road"'),
('Rangpur', '"Alamdangha", "Bodorgonj", "College Para", "Dhap", "Jahaj Company Mor", "Kachari Bazar", "Mahigonj", "Mithapukur", "Modern More", "Paglapir", "Pourobazar", "Shapla Chottor", "Shathibari", "Shatmatha Chottor", "Shatrasta Mor", "Tajhat", "Vinno Jogot"'),
('Brhamanbaria', 'Brhamanbaria'),
('Jessore', 'Jessore'),
('Saidpur', 'Saidpur'),
('Narayanganj', 'Narayanganj'),
('Gaibandha', 'Gaibandha'),
('Naogaon', 'Naogaon')

CREATE TABLE PERSON_BIRTH_C
(
Birth_Registration_Number VARCHAR(17) NOT NULL  PRIMARY KEY,
Birth_Date DATE NOT NULL,
Mobile_Number VARCHAR(11) UNIQUE NOT NULL,
City VARCHAR(45) NOT NULL,
Area VARCHAR(45) NOT NULL,
Ward_Number INT NOT NULL,
Age INT NOT NULL
)

SELECT * FROM PERSON_BIRTH_C

CREATE TABLE PERSON_NID 
(
NID VARCHAR(10) NOT NULL PRIMARY KEY,
Birth_Date DATE NOT NULL,
Mobile_Number VARCHAR(11) UNIQUE NOT NULL,
City VARCHAR(45) NOT NULL,
Area VARCHAR(45) NOT NULL,
Ward_Number INT NOT NULL,
Age INT NOT NULL
);

SELECT * FROM PERSON_NID

CREATE TABLE VACCINATION_CENTER (
Center_ID INT NOT NULL PRIMARY KEY,
Institute_Name VARCHAR(45) NOT NULL,
Amount_Registered INT NOT NULL,
City VARCHAR(45) NOT NULL,
Area VARCHAR(45) NOT NULL,
Batch_Number INT NOT NULL
);

SELECT * FROM VACCINATION_CENTER		
			
INSERT INTO VACCINATION_CENTER VALUES
			(1, 'Mohanagar Institute', 4000, 'Dhaka', 'Shantinagar', 4),
			(2, 'Jahangir Institute', 6000, 'Dhaka', 'Dhanmonddi', 1),
			(3, 'Some institute', 5693, 'Chittagong', 'Chittagong', 6),
			(5, 'Think Insititute', 6395, 'Dhaka', 'Gulshan', 5),
			(4, 'Popular Diagnostics', 356, 'Dhaka', 'Shahabhag', 2),
			(7, 'Eye Diagnostics', 3621, 'Narayanganj', 'Narayanganj', 7),
			(26, 'Yes Hospital', 3111, 'Dhaka', 'Cantonment', 70);

CREATE TABLE STORAGE 
(
Batch_Number INT NOT NULL PRIMARY KEY,
Amount_Administered INT NOT NULL,
Amount_Left INT NOT NULL,
Manufactured_Date DATE NOT NULL,
Expiration_Date DATE NOT NULL,
Center_ID INT NOT NULL FOREIGN KEY REFERENCES VACCINATION_CENTER(Center_ID),
Vaccine_Brand VARCHAR(45) FOREIGN KEY REFERENCES DISTRIBUTION_CENTER(Vaccine_Brand),
IsExpired INT NOT NULL DEFAULT 0
);

SELECT * FROM STORAGE

INSERT INTO STORAGE VALUES(10, 20, 5, '2021-09-08', '2022-09-22', 26, 'Pfizer', 0),
						  (11, 20, 15, '2021-09-08', '2021-09-22', 3, 'Morderna', 0),
						  (12, 20, 25, '2021-09-08', '2023-09-22', 2, 'Sputnik V', 0)

CREATE TABLE COVID_AFFECTED 
(
Identifier VARCHAR(17) NOT NULL PRIMARY KEY,
IsAffected INT NOT NULL,
Age_Allowed_Vaccine INT NOT NULL CHECK (Age_Allowed_Vaccine >= 18),
Serial INT NOT NULL
);

---------Count the current serial no-----------
SELECT COUNT(Serial) AS Serial FROM COVID_AFFECTED

SELECT * FROM COVID_AFFECTED

CREATE TABLE VACCINE 
(
Identifier VARCHAR(17) UNIQUE,
First_Dose_Date DATE NULL,
Second_Dose_Date DATE NULL,
Center_Id INT FOREIGN KEY REFERENCES VACCINATION_CENTER (Center_Id),
Vaccine_Brand varchar(45) FOREIGN KEY REFERENCES DISTRIBUTION_CENTER (Vaccine_Brand)
);

SELECT * FROM VACCINE

INSERT INTO VACCINE (Identifier, First_Dose_Date, Second_Dose_Date, Center_Id, Vaccine_Brand)
VALUES ('121434334', '2020-09-20', '2020-12-09', 1, 'AstraZeneca'),
	   ('121433034', '2020-09-20', '2020-12-09', 7 , 'AstraZeneca'),
	   ('122734334', '2020-09-20', '2020-12-09', 4 , 'Pfizer'),
	   ('12164334', '2020-09-20', '2020-12-09', 26 , 'Pfizer'),
       ('1234', '2021-05-01', '2020-04-01', 2 , 'Sputnik V');

--------> END of Table information


--------> Generating Identifier,age,city,area,dose dates for dashboard

SELECT c.Serial, p.Identifier, p.Age, p.City, p.Area, v.First_Dose_Date, v.Second_Dose_Date 
	FROM VACCINE v JOIN (SELECT Birth_Registration_Number AS 'Identifier' , Birth_Date, Mobile_Number, City, Area, Ward_Number, Age 
	FROM PERSON_BIRTH_C UNION SELECT NID AS 'Identifier', Birth_Date, Mobile_Number, City, Area, Ward_Number, Age FROM PERSON_NID) p 
	ON (v.Identifier = p.Identifier) JOIN COVID_AFFECTED c ON (c.Identifier = p.Identifier) order by c.Serial asc, p.Age desc, v.First_Dose_Date asc 

--Finding corresponding institution where max amount of vaccine is left

SELECT Institute_Name FROM VACCINATION_CENTER WHERE Center_ID = 
ANY(SELECT Center_ID FROM STORAGE WHERE Amount_Left = ANY(SELECT MAX(Amount_Left)
												  FROM (SELECT v.*, s.Amount_Left 
														FROM STORAGE s JOIN (SELECT * FROM VACCINATION_CENTER WHERE City = 
																			 ANY((SELECT City FROM PERSON_BIRTH_C UNION SELECT City FROM PERSON_NID) INTERSECT SELECT city FROM VACCINATION_CENTER)) v
														ON v.Center_ID = s.Center_ID) VS GROUP BY City HAVING City = 'Chittagong'))

--------> Amount left

SELECT SUM(Amount_left) FROM STORAGE

--------> Amount Administered

SELECT SUM(Amount_Administered) FROM STORAGE

--------> Generating certificate of vaccination

SELECT u.NID AS 'Identifier', id.FullName, u.Birth_Date, id.Gender, v.First_Dose_Date, v.Vaccine_Brand, v.Second_Dose_Date, v.Vaccine_Brand, vc.Institute_Name  FROM VACCINE v INNER JOIN
(SELECT * FROM PERSON_NID UNION SELECT * FROM PERSON_BIRTH_C) u ON u.NID = v.identifier INNER JOIN
IDENTIFIER_INFORMATION id ON id.Identifier = v.Identifier INNER JOIN
VACCINATION_CENTER vc ON vc.Center_ID = v.Center_Id WHERE v.Identifier = '121434334' AND v.Second_Dose_Date IS NOT NULL

----------->Show serial no
SELECT Serial FROM COVID_AFFECTED WHERE Identifier = '1000000003';


SELECT v.Center_Id, v.Identifier, id.FullName, id.Gender,v.First_Dose_Date, v.Second_Dose_Date,v.Vaccine_Brand, vc.Institute_Name FROM VACCINE v
INNER JOIN VACCINATION_CENTER vc ON v.Center_ID = vc.Center_Id
INNER JOIN IDENTIFIER_INFORMATION id ON v.Identifier = id.Identifier WHERE v.Identifier= '1234'

SELECT * FROM IDENTIFIER_INFORMATION WHERE IDENTIFIER = '121434334'

SELECT * FROM VACCINE v
INNER JOIN IDENTIFIER_INFORMATION ON v.Identifier = IDENTIFIER_INFORMATION.Identifier


