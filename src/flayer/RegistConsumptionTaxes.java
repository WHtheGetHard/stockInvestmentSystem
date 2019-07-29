package flayer;

import dlayer.InsertConsumptionTaxes;
import fieldformat.ConsumptionTaxes;
import fieldformat.DisplayContentsConsumptionTaxes;

public class RegistConsumptionTaxes {
	public void execRegistration(DisplayContentsConsumptionTaxes displayContentsConsumptionTaxes) {
		ConsumptionTaxes consumptionTaxes = new ConsumptionTaxes();

		consumptionTaxes.setTaxRate(displayContentsConsumptionTaxes.getComsumptionTax());
		consumptionTaxes.setStartDay(displayContentsConsumptionTaxes.getStartDate());
		consumptionTaxes.setEndDay(displayContentsConsumptionTaxes.getEndDate());


		InsertConsumptionTaxes insertConsumptionTaxes = new InsertConsumptionTaxes();
		ConfirmConsumptionTaxesRegistered confirmConsumptionTaxesRegistered = new ConfirmConsumptionTaxesRegistered();

		// TODO : confirm term is overlaped
		boolean isOverlaped = confirmConsumptionTaxesRegistered.isOverlap(
				displayContentsConsumptionTaxes.getStartDate(), displayContentsConsumptionTaxes.getEndDate());

		// TODO : if term is overlaped
		if (isOverlaped) {
			// TODO : decide specification
		} else {
			// TODO : else not overlaped, insert to consumption_taxes table
			insertConsumptionTaxes.execInsert(consumptionTaxes);
		}
	}
}
