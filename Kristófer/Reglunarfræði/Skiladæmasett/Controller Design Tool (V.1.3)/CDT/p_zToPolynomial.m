function [out] = p_zToPolynomial(vec)
% Changes pole/zero input to polynomial given a set of locations.
% input 
%           vec   =    vector of legitimate inputs, has been checked if  
%                      imaginary numbers all have conjugates
% output
%           out   =    vector in the form of a polynomial



syms s;
n = length(vec);

if n==1 & vec(1) == 0
    out = [1 0];
else
    eq = 1;
    for i = 1:n
        if (vec(i) ~= 0) 
            eq = eq*(s+vec(i));
        else
            eq = eq*s;
        end
    end

    eq = expand(eq);
    out = sym2poly(eq);
end