package br.cefetrj.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import br.cefetrj.service.ContaService;

public class CustomJwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken>
{
    private final ContaService contaService;

    public CustomJwtAuthConverter(ContaService contaService)
    {
        this.contaService = contaService;

    }

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt)
    {
        String email = jwt.getClaimAsString("email");

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        var conta = contaService.listarPorEmail(email).orElse(null);
        if(conta != null)
        { 
            authorities.add(new SimpleGrantedAuthority("ROLE_" + conta.getPapel()));

        }

        return new JwtAuthenticationToken(jwt, authorities);
    }

}
