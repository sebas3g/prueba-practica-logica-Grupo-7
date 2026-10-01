
// GRUPO 7 - ExpressLogistics: Envios
// Tarifas por kg: 1 Local $1.50 | 2 Nacional $3.50 | 3 Internacional $9.00
// Recargo Express: 25% sobre el costo
// Pesos mayores a 10 kg se rechazan
Algoritmo ExpressLogistics
	Definir n, i, zona, cantExpress, cantRechazados, cantProcesados Como Entero
	Definir peso, tarifaKg, costo, recargo, totalFacturado, pesoMax Como Real
	Definir guia, guiaMax, resp Como Caracter

	// Inicializacion de contadores, acumulador y maximo
	totalFacturado <- 0
	cantExpress <- 0
	cantRechazados <- 0
	cantProcesados <- 0
	pesoMax <- 0
	guiaMax <- "Ninguna"

	Escribir "===== EXPRESSLOGISTICS - CONTROL DE ENVIOS ====="

	// Validacion de la cantidad de envios
	Repetir
		Escribir "Ingrese la cantidad de envios a procesar: "
		Leer n
		Si n <= 0 Entonces
			Escribir "Error: la cantidad debe ser mayor a 0."
		FinSi
	Hasta Que n > 0

	Para i <- 1 Hasta n Con Paso 1 Hacer
		Escribir ""
		Escribir "------ Envio ", i, " de ", n, " ------"
		Escribir "Numero de guia: "
		Leer guia

		// Validacion del peso
		Repetir
			Escribir "Peso del paquete (kg): "
			Leer peso
			Si peso <= 0 Entonces
				Escribir "Error: el peso debe ser mayor a 0."
			FinSi
		Hasta Que peso > 0

		Si peso > 10 Entonces
			Escribir "ENVIO RECHAZADO: el peso supera los 10 kg."
			cantRechazados <- cantRechazados + 1
		SiNo
			// Validacion de la zona
			Repetir
				Escribir "Zona (1 Local, 2 Nacional, 3 Internacional): "
				Leer zona
				Si zona < 1 O zona > 3 Entonces
					Escribir "Error: la zona debe ser 1, 2 o 3."
				FinSi
			Hasta Que zona >= 1 Y zona <= 3

			// Validacion de Express
			Repetir
				Escribir "Es envio Express? (S/N): "
				Leer resp
				resp <- Mayusculas(resp)
				Si resp <> "S" Y resp <> "N" Entonces
					Escribir "Error: responda S o N."
				FinSi
			Hasta Que resp = "S" O resp = "N"

			// Tarifa segun la zona
			Segun zona Hacer
				1:
					tarifaKg <- 1.50
					Escribir "Zona: Local"
				2:
					tarifaKg <- 3.50
					Escribir "Zona: Nacional"
				3:
					tarifaKg <- 9.00
					Escribir "Zona: Internacional"
				De Otro Modo:
					tarifaKg <- 0
			FinSegun

			costo <- peso * tarifaKg

			// Recargo por envio Express
			recargo <- 0
			Si resp = "S" Entonces
				recargo <- costo * 0.25
				cantExpress <- cantExpress + 1
			FinSi
			costo <- costo + recargo

			// Acumulador y contador
			totalFacturado <- totalFacturado + costo
			cantProcesados <- cantProcesados + 1

			// Paquete mas pesado (maximo)
			Si peso > pesoMax Entonces
				pesoMax <- peso
				guiaMax <- guia
			FinSi

			Escribir "Guia: ", guia, " | Recargo: $", recargo, " | Total a pagar: $", costo
		FinSi
	FinPara

	// Resultados finales
	Escribir ""
	Escribir "=============== RESUMEN ==============="
	Escribir "Envios procesados: ", cantProcesados
	Escribir "Envios rechazados (> 10 kg): ", cantRechazados
	Escribir "Total facturado: $", totalFacturado
	Escribir "Cantidad de envios Express: ", cantExpress
	Si cantProcesados > 0 Entonces
		Escribir "Paquete mas pesado: guia ", guiaMax, " con ", pesoMax, " kg"
	SiNo
		Escribir "No se proceso ningun envio."
	FinSi
	Escribir "Fin del programa."
FinAlgoritmo
