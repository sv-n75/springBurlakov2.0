
delete from address_consolidation_of_skills;

insert into address_consolidation_of_skills ( address_id, region_code, district_name, name_of_town, street_name, house_number, case_number, office_room_number)
values
(1,  54, 'Siberia', 'Novosibirsk', 'Startovaya', 1, 451,0),
( 2, 55, 'Siberia', 'Lenina', 'Omsk',  18, 8,100);



delete from clients_consolidation_of_skills;

insert into clients_consolidation_of_skills(client_id, title, individual_tax_number,
phone_number, address_id)
values
(1, 'OOO Uspeh', '540002', '001', 1),
(2, 'OOO stroy-sity', '540003', '002', 2);

delete from order_consolidation_of_skills;

insert into order_consolidation_of_skills(order_id, number, date_of_creation, description, sum, client_id)
values
(1, 253, '2022-10-10', 'очень вкусный чай', 1500, 1),
(2, 254, '2022-01-10', 'milk', 2500, 1),
(3, 255, '2022-02-10', 'tea', 100, 2);