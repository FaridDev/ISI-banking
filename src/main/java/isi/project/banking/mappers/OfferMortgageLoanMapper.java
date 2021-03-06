package isi.project.banking.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import isi.project.banking.dto.OfferMortgageLoanDto;
import isi.project.banking.model.OfferMortgageLoan;

@Component
public class OfferMortgageLoanMapper implements BaseMapper<OfferMortgageLoan, OfferMortgageLoanDto> {

	@Autowired
	ManagerMapper managerMapper;

	@Override
	public OfferMortgageLoanDto map(OfferMortgageLoan from) {
		return OfferMortgageLoanDto.builder()
				.id(from.getId())
				.name(from.getName())
				.interest(from.getInterest())
				.interestType(from.getInterestType())
				.minSum(from.getMinSum())
				.maxSum(from.getMaxSum())
				.minInstallments(from.getMinInstallments())
				.maxInstallments(from.getMaxInstallments())
				.author(from.getAuthor())
				.manager(managerMapper.map(from.getManager()))
				.build();
	}

	@Override
	public OfferMortgageLoan unmap(OfferMortgageLoanDto from) {
		return OfferMortgageLoan.builder()
				.id(from.getId())
				.name(from.getName())
				.interest(from.getInterest())
				.interestType(from.getInterestType())
				.minSum(from.getMinSum())
				.maxSum(from.getMaxSum())
				.minInstallments(from.getMinInstallments())
				.maxInstallments(from.getMaxInstallments())
				.author(from.getAuthor())
				.manager(managerMapper.unmap(from.getManager()))
				.build();
	}
	
}
