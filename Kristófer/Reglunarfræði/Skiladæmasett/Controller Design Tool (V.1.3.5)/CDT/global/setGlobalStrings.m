function setGlobalStrings(k ,num, den, strVal)
global fKstring fNumString fDenString cKstring cNumString cDenString ...
    gKstring gNumString gDenString hKstring hNumString hDenString;
switch strVal
    case 'F(s)'
        fKstring   = k;
        fNumString = num;
        fDenString = den;
    case 'C(s)'
        cKstring   = k;
        cNumString = num;
        cDenString = den;
    case 'G(s)'
        gKstring   = k;
        gNumString = num;
        gDenString = den;
    case 'H(s)'
        hKstring   = k;
        hNumString = num;
        hDenString = den;
end