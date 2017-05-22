package isi.project.banking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.project.banking.dto.ClientDto;
import isi.project.banking.exceptions.EntityNotFoundException;
import isi.project.banking.mappers.ClientMapper;
import isi.project.banking.model.Client;
import isi.project.banking.repository.ClientRepository;
import isi.project.banking.service.ClientService;

@Service("ClientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ClientMapper clientMapper;
	
	@Override
	public Optional<ClientDto> findOne(String pesel) {
		return Optional.ofNullable(clientMapper.map(clientRepository.findOne(pesel)));
	}
	@Override
	public List<ClientDto> findAll() {
		return clientMapper.map(clientRepository.findAll());
	}
	@Override
	public Optional<ClientDto> save(ClientDto clientDto) {
		return Optional.ofNullable(clientMapper.map(clientRepository.save(clientMapper.unmap(clientDto))));
	}

	@Override
	public Optional<ClientDto> update(ClientDto clientDto) {
		return Optional.ofNullable(clientMapper.map(clientRepository.save(clientMapper.unmap(clientDto))));
	}
	@Override
	@Transactional
	public void remove(String pesel) throws EntityNotFoundException {
		clientRepository.delete(clientMapper.unmap(findOne(pesel).orElseThrow(() 
				-> new EntityNotFoundException("Client with that pesel not found!"))));
	}
	

}
