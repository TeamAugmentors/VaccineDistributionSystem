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


CREATE TABLE ADMIN_PANEL (
	ID INT IDENTITY(1 ,1) PRIMARY KEY NOT NULL,
	FirstName varchar(50) NOT NULL,
	LastName varchar(50) NOT NULL,
	Username varchar(50) NOT NULL,
	PasswordHash varchar(28) NOT NULL
)	

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

INSERT INTO DISTRIBUTION_CENTER VALUES('Pfizer', 1, 1, 13100000, 3600000, 3600000, 360000, 147073),
									  ('AstraZeneca', 1, 1, 35700000, 7000000, 6500000, 13500000, 12800000),
									  ('Sputnik V', 1, 0, 40000000, NULL, NULL, NULL, NULL),
									  ('Sinopharm', 1, 1, 75000000, 29000000,  5500000, 34500000, 22800000),
									  ('Sinovac', 1, 0, NULL, NULL,  NULL, NULL, NULL),
									  ('Janssen', 1, 0, NULL, NULL, NULL, NULL, NULL),
									  ('Morderna', 1, 1, 7300000, 5500000,  5500000, 5500000, 510000)
SELECT * FROM DISTRIBUTION_CENTER

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
Mobile_Number VARCHAR(11) NOT NULL,
City VARCHAR(45) NOT NULL,
Area VARCHAR(45) NOT NULL,
Ward_Number INT NOT NULL,
Age INT NOT NULL
)

CREATE TABLE PERSON_NID 
(
NID VARCHAR(10) NOT NULL PRIMARY KEY,
Birth_Date DATE NOT NULL,
Mobile_Number VARCHAR(11) NOT NULL,
City VARCHAR(45) NOT NULL,
Area VARCHAR(45) NOT NULL,
Ward_Number INT NOT NULL,
Age INT NOT NULL
);

CREATE TABLE VACCINATION_CENTER (
Center_ID INT NOT NULL PRIMARY KEY,
Institute_Name VARCHAR(45) NOT NULL,
Amount_Registered INT NOT NULL,
Center_Location VARCHAR(45) NOT NULL,
Batch_Number INT NOT NULL
);

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

CREATE TABLE COVID_AFFECTED 
(
NID VARCHAR(10) NOT NULL PRIMARY KEY,
IsAffected INT NOT NULL,
Cure_Date DATE NOT NULL,
IsAllowed_Vaccine INT NOT NULL
);

CREATE TABLE VACCINE 
(
Registered_NID VARCHAR(10) NOT NULL PRIMARY KEY,
First_Dose_Date DATE NULL,
Second_Dose_Date DATE NULL
);
select * from VACCINE
INSERT INTO VACCINE (Registered_NID, First_Dose_Date, Second_Dose_Date)
VALUES('121434334', '2020-09-20', '2020-12-09');


INSERT INTO VACCINE(Registered_NID, First_Dose_Date, Second_Dose_Date)
values ('1234', '2021-05-01', '2020-04-01');

INSERT INTO ADMIN_PANEL VALUES ('Sanjid', 'Chowdhury', 'Lassassin', '123456'),
						 ('Tanim', 'Ahmed', 'AST.A.S.T.', '123456'),
						 ('Atikur', 'Rahman', 'Atiq', '123456'),
						 ('Tanim', 'Ahmed', 'A.S.T.', '123456'),
						 ('Atikur', 'Rahman', 'Cyberman', '123456')

INSERT INTO INFORMATION VALUES ('Dhaka'), 
							   ('M')

SELECT * FROM ADMIN_PANEL

SELECT Username, PasswordHash FROM ADMIN_PANEL WHERE Username='Lassassin' AND PasswordHash = '123456'

ALTER TABLE VACCINATION_CENTER
ADD FOREIGN KEY (Batch_Number) REFERENCES STORAGE(Batch_Number);


select * from ADMIN_PANEL


SELECT p.Identifier, p.Age, p.City, p.Area, v.First_Dose_Date, v.Second_Dose_Date
FROM VACCINE v JOIN (SELECT Birth_Registration_Number AS 'Identifier' , Birth_Date, Mobile_Number, City, Area, Ward_Number, Age  FROM PERSON_BIRTH_C UNION
					 SELECT NID AS 'Identifier', Birth_Date, Mobile_Number, City, Area, Ward_Number, Age FROM PERSON_NID) p
ON (v.Identifier = p.Identifier) 
order by p.Age desc, v.First_Dose_Date asc 

(SELECT center_id FROM VACCINATION_CENTER
WHERE City = ( (SELECT City FROM PERSON_BIRTH_C UNION
				SELECT City FROM PERSON_NID) INTERSECT SELECT city FROM VACCINATION_CENTER) )
