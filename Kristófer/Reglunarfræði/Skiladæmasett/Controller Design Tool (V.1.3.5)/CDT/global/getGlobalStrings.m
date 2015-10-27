function [k, num, den] = getGlobalStrings(strVal)
global fKstring fNumString fDenString cKstring cNumString cDenString...
    gKstring gNumString gDenString hKstring hNumString hDenString;

switch strVal
    case 'F(s)'
        k   = fKstring; 
        num = fNumString;
        den = fDenString;
    case 'C(s)'
        k   = cKstring;
        num = cNumString;
        den = cDenString;
    case 'G(s)'
        k   = gKstring;
        num = gNumString;
        den = gDenString;
    case 'H(s)'
        k   = hKstring;
        num = hNumString;
        den = hDenString;
end