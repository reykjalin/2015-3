addpath CDT CDT/global CDT/Help;
h = waitbar(0,'Opening Controller Design Tool');
for i = 1:10
    waitbar(i/10);
    if i == 7
        run('CDT/ControllerDesignTool.m');
    end
end
close(h);
disp('Controller Design Tool [CDT]')
disp('Author: David Orn Johannesson')
disp('davidj11@hr.is')
disp('Reykjavik University')
disp('2015')
