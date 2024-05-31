package com.main.gharrImaratApp.model;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode
public class UserAgentId {

	private UUID userAgent1ID;
	private UUID userAgent2ID; 
}
