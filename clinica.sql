drop database if exists Clinica;
create database Clinica;
use Clinica;

create table Medicos(
	idMedico int primary key,
	nombreCompleto varchar(100),
    nroCategoria varchar(20),
    telefono varchar(20),
    email varchar(100),
    especialidadId int,
    especialidadNombre varchar(30)
);

create table Pacientes(
	idPaciente int primary key,
    nombreCompleto varchar(100),
    documentoIdentidad varchar(20),
    fechaNacimiento date,
    sexo char,
    direccion varchar(100),
	telefono varchar(20),
    email varchar(100)
);

create table Medicamentos(
	idMedicamento int primary key,
    nombreComercial varchar(100),
    principioActivo varchar(100),
    presentacion varchar(100),
    viaAdministracion varchar(50)
    /*diagnosticos asociados fk?*/
);

create table Cita(
	idCita int primary key,
    idPaciente int,
    idMedico int,
	foreign key (idPaciente) references Pacientes(idPaciente),
    foreign key (idMedico) references Medicos(idMedico),
    fechaHora datetime,
    motivo varchar(200),
    estado enum("programada","atendida","cancelada")
);

create table Receta(
	idReceta int primary key,
    idCita int,
    foreign key (idCita) references Cita(idCita),
    fecha date,
    observaciones text
);

create table RecetaDetalle(
	idRecetaDetalle int primary key,
    idReceta int,
    idMedicamento int,
    foreign key (idReceta) references Receta(idReceta),
    foreign key (idMedicamento) references Medicamentos(idMedicamento),
    dosis varchar(60),
    frecuencia  varchar(60),
    duracionDias int,
    instrucciones text
);



INSERT INTO Medicos (idMedico, nombreCompleto, nroCategoria, telefono, email, especialidadId, especialidadNombre) VALUES
(1001, 'Dra. Laura Méndez', 'CAT-1001', '600111222', 'laura.mendez@saludtotal.com', 1, 'Medicina General'),
(1002, 'Dr. Andrés Pardo', 'CAT-1002', '600222333', 'andres.pardo@saludtotal.com', 3, 'Cardiología'),
(1003, 'Dra. Silvia Ríos', 'CAT-1003', '600333444', 'silvia.rios@saludtotal.com', 4, 'Dermatología'),
(1004, 'Dr. Miguel Torres', 'CAT-1004', '600444555', 'miguel.torres@saludtotal.com', 5, 'Neumología'),
(1005, 'Dra. Paula Gómez', 'CAT-1005', '600555666', 'paula.gomez@saludtotal.com', 2, 'Pediatría');

INSERT INTO Pacientes (idPaciente, nombreCompleto, documentoIdentidad, fechaNacimiento, sexo, direccion, telefono, email) VALUES
(3001, 'Simón Pedro', 'DNI-9101', '1980-02-15', 'M', 'C/ Galilea 10, Madrid', '610111001', 'simon.pedro@email.com'),
(3002, 'Andrés de Betsaida', 'DNI-9102', '1983-07-09', 'M', 'Av. Norte 45, Madrid', '610111002', 'andres.betsaida@email.com'),
(3003, 'Santiago el Mayor', 'DNI-9103', '1978-05-22', 'M', 'C/ Río 4, Madrid', '610111003', 'santiago.mayor@email.com'),
(3004, 'Juan de Zebedeo', 'DNI-9104', '1985-09-11', 'M', 'C/ Lago Azul 7, Madrid', '610111004', 'juan.zebedeo@email.com'),
(3005, 'Felipe de Betsaida', 'DNI-9105', '1990-03-27', 'M', 'C/ Prado 12, Madrid', '610111005', 'felipe.betsaida@email.com'),
(3006, 'Bartolomé Natanael', 'DNI-9106', '1982-10-05', 'M', 'C/ Monte Olivo 9, Madrid', '610111006', 'bartolome.natanael@email.com'),
(3007, 'Tomás Dídimo', 'DNI-9107', '1986-06-20', 'M', 'Av. Sur 8, Madrid', '610111007', 'tomas.didimo@email.com'),
(3008, 'Mateo Leví', 'DNI-9108', '1975-01-30', 'M', 'C/ Templo 3, Madrid', '610111008', 'mateo.levi@email.com'),
(3009, 'Santiago el Menor', 'DNI-9109', '1992-12-15', 'M', 'C/ Pescadores 6, Madrid', '610111009', 'santiago.menor@email.com'),
(3010, 'Judas Tadeo', 'DNI-9110', '1988-11-08', 'M', 'C/ Cedros 14, Madrid', '610111010', 'judas.tadeo@email.com'),
(3011, 'Simón el Zelote', 'DNI-9111', '1979-04-19', 'M', 'C/ Jardín 1, Madrid', '610111011', 'simon.zelote@email.com'),
(3012, 'Judas Iscariote', 'DNI-9112', '1984-08-25', 'M', 'C/ Mercado 22, Madrid', '610111012', 'judas.iscariote@email.com');

INSERT INTO Medicamentos (idMedicamento, nombreComercial, principioActivo, presentacion, viaAdministracion) VALUES
(7001, 'Paracetamol 500', 'Paracetamol', '500 mg comprimidos', 'Oral'),
(7002, 'Amoxicilina 875/125', 'Amoxicilina / Ácido clavulánico', '875/125 mg comprimidos', 'Oral'),
(7003, 'Loratadina 10', 'Loratadina', '10 mg comprimidos', 'Oral'),
(7004, 'Salbutamol Inhalador', 'Salbutamol', '100 mcg/dosis inhalador', 'Inhalatoria'),
(7005, 'Betametasona Crema', 'Betametasona', '0.05% crema 30 g', 'Tópica'),
(7006, 'Omeprazol 20', 'Omeprazol', '20 mg cápsulas', 'Oral'),
(7007, 'Losartán 50', 'Losartán', '50 mg comprimidos', 'Oral'),
(7008, 'Hidroclorotiazida 25', 'Hidroclorotiazida', '25 mg comprimidos', 'Oral'),
(7009, 'Clotrimazol Crema', 'Clotrimazol', '1% crema 20 g', 'Tópica'),
(70010, 'Salbutamol Jarabe', 'Salbutamol', '2 mg/5ml jarabe 120 ml', 'Oral'),
(70011, 'Ibuprofeno 400', 'Ibuprofeno', '400 mg comprimidos', 'Oral'),
(70012, 'Ácido Acetilsalicílico 100', 'AAS', '100 mg comprimidos', 'Oral'),
(70013, 'Mupirocina Ungüento', 'Mupirocina', '2% ungüento 15 g', 'Tópica'),
(70014, 'Cetirizina 10', 'Cetirizina', '10 mg comprimidos', 'Oral'),
(70015, 'Diazepam 5', 'Diazepam', '5 mg comprimidos', 'Oral');

INSERT INTO Cita (idCita, idPaciente, idMedico, fechaHora, motivo, estado) VALUES
(1, 3001, 1001, '2025-11-06 09:30:00', 'Dolor de garganta, fiebre leve y malestar general.', 'atendida'),
(2, 3002, 1003, '2025-11-06 11:00:00', 'Irritación cutánea en brazos tras usar detergente nuevo.', 'atendida'),
(3, 3004, 1004, '2025-11-06 15:00:00', 'Dificultad respiratoria y tos nocturna.', 'atendida'),
(4, 3005, 1001, '2025-11-07 10:00:00', 'Dolor abdominal poscomida, ardor estomacal.', 'atendida'),
(5, 3003, 1002, '2025-11-08 09:00:00', 'Control de presión arterial; refiere cefalea leve.', 'atendida'),
(6, 3003, 1003, '2025-11-08 11:30:00', 'Lesión descamativa entre los dedos del pie derecho.', 'atendida'),
(7, 3008, 1005, '2025-11-09 16:00:00', 'Dolor de oído derecho, congestión nasal.', 'atendida'),
(8, 3007, 1004, '2025-11-10 09:00:00', 'Tos seca y malestar general sin fiebre alta.', 'atendida'),
(9, 3001, 1002, '2025-11-10 12:00:00', 'Dolor lumbar leve y mareos esporádicos.', 'atendida'),
(10, 3009, 1001, '2025-11-11 08:30:00', 'Congestión nasal y estornudos frecuentes.', 'atendida'),
(11, 3005, 1002, '2025-11-11 11:00:00', 'Revisión de tratamiento antihipertensivo.', 'atendida'),
(12, 3001, 1003, '2025-11-12 15:00:00', 'Lesión en antebrazo con costra y enrojecimiento.', 'atendida');


INSERT INTO Receta (idReceta, idCita, fecha, observaciones) VALUES
(1, 1, '2025-11-06', 'Faringoamigdalitis aguda (J02.9). Reposo 3 días, mantener hidratación, reevaluar si fiebre persiste.'),
(2, 2, '2025-11-06', 'Dermatitis de contacto irritativa (L24.9). Aplicar capa fina dos veces al día por 5 días; evitar el producto causante.'),
(3, 3, '2025-11-06', 'Crisis asmática leve (J45.2). 2 inhalaciones cada 8 horas durante 3 días; control a la semana.'),
(4, 4, '2025-11-07', 'Dispepsia funcional (K30). Tomar 1 cápsula diaria antes del desayuno durante 14 días.'),
(5, 5, '2025-11-08', 'Hipertensión arterial no controlada (I10). Reanudar medicación diaria; medir presión cada 3 días.'),
(6, 6, '2025-11-08', 'Tinea pedis (pie de atleta) (B35.3). Aplicar 2 veces al día durante 14 días; mantener pies secos.'),
(7, 7, '2025-11-09', 'Otitis media aguda (H66.9). Tomar antibiótico 7 días, analgésico cada 8h; mantener oído seco.'),
(8, 8, '2025-11-10', 'Infección respiratoria alta viral (J06.9). Tratamiento sintomático; líquidos abundantes; reposo domiciliario.'),
(9, 9, '2025-11-10', 'Lumbalgia mecánica leve (M54.5). Reposo relativo; evitar cargar peso; analgésico cada 8h.'),
(10, 10, '2025-11-11', 'Rinitis alérgica estacional (J30.1). 1 tableta diaria por 7 días; evitar polvo y flores.'),
(11, 11, '2025-11-11', 'Hipertensión arterial controlada (I10). Mantener dosis actual; control cada 30 días.'),
(12, 12, '2025-11-12', 'Dermatitis infectada leve (L08.0). Aplicar capa fina 3 veces/día por 5 días; cubrir con gasa limpia.');
/*
INSERT INTO RecetaDetalle (idRecetaDetalle, idReceta, idMedicamento, dosis, frecuencia, duracionDias, instrucciones) VALUES
-- Caso 1 (Receta 1)
(1, 1, 7001, '500 mg', 'Cada 8 horas (SOS)', 3, 'Para la fiebre y el dolor.'),
(2, 1, 7002, '875/125 mg', 'Cada 12 horas', 7, 'Antibiótico, completar la dosis.'),
-- Caso 2 (Receta 2)
(3, 2, 7005, '0.05% crema', '2 veces al día', 5, 'Aplicar capa fina.'),
-- Caso 3 (Receta 3)
(4, 3, 7004, '100 mcg/dosis', '2 inhalaciones cada 8 horas', 3, 'Usar al notar dificultad para respirar.'),
-- Caso 4 (Receta 4)
(5, 4, 7006, '20 mg', '1 diaria', 14, 'Tomar 1 cápsula antes del desayuno.'),
-- Caso 5 (Receta 5)
(6, 5, 7007, '50 mg', '1 diaria', NULL, 'Mantener dosis actual.'),
(7, 5, 7008, '25 mg', '1 diaria', NULL, 'Mantener dosis actual.'),
-- Caso 6 (Receta 6) - ¡Asegurado!
(8, 6, 7009, '1% crema', '2 veces al día', 14, 'Aplicar hasta que la lesión desaparezca.'),
-- Caso 7 (Receta 7)
(9, 7, 7002, '875/125 mg', 'Cada 12 horas', 7, 'Antibiótico, completar la dosis.'),
(10, 7, 7001, '500 mg', 'Cada 8 horas (SOS)', 5, 'Para el dolor y la fiebre.'),
-- Caso 8 (Receta 8)
(11, 8, 7010, 'Según peso/edad', 'Cada 8 horas', 5, 'Para la tos y congestión.'),
(12, 8, 7001, '500 mg', 'Cada 8 horas (SOS)', 3, 'Para el malestar general.'),
-- Caso 9 (Receta 9)
(13, 9, 7011, '400 mg', 'Cada 8 horas', 3, 'Analgésico/Antiinflamatorio.'),
(14, 9, 7015, '5 mg', '1 antes de dormir', 3, 'Relajante muscular.'),
-- Caso 10 (Receta 10)
(15, 10, 7003, '10 mg', '1 diaria', 7, 'Antihistamínico.'),
-- Caso 11 (Receta 11)
(16, 11, 7007, '50 mg', '1 diaria', NULL, 'Mantener tratamiento antihipertensivo.'),
-- Caso 12 (Receta 12)
(17, 12, 7013, 'Capa fina', '3 veces al día', 5, 'Aplicar en la zona de la lesión, cubrir con gasa.');
*/