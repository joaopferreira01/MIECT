from vtkmodules.all import *


##############################
# Callback for the interaction
##############################
class vtkMyCallback(object):
    def __init__(self, renderer):
        self.ren = renderer

    def __call__(self, caller, ev):
        # Print the class name of the caller and the event ID
        print(caller.GetClassName(), 'Event Id:', ev)
        # Print the current camera position
        cam_pos = self.ren.GetActiveCamera().GetPosition()
        print("Camera Position: %f, %f, %f" % (cam_pos[0], cam_pos[1], cam_pos[2]))


def main():
    # Create an instance of vtkConeSource and set some properties
    coneSource = vtkConeSource()
    coneSource.SetHeight(2.0)
    coneSource.SetRadius(1.0)
    coneSource.SetResolution(50)

    # Create a mapper and connect it to the cone source
    coneMapper = vtkPolyDataMapper()
    coneMapper.SetInputConnection(coneSource.GetOutputPort())

    # Create an actor for the cone
    coneActor = vtkActor()
    coneActor.SetMapper(coneMapper)

    # Create the renderer and assign the actor to it
    ren = vtkRenderer()
    ren.AddActor(coneActor)
    ren.SetBackground(1.0, 0.55, 0.41)

    # Create the render window and add the renderer
    renWin = vtkRenderWindow()
    renWin.AddRenderer(ren)
    renWin.SetSize(640, 480)
    renWin.SetWindowName('Cone with Interaction and Callback')

    # Create the render window interactor
    iren = vtkRenderWindowInteractor()
    iren.SetRenderWindow(renWin)

    # Add the callback observer to the renderer
    mo1 = vtkMyCallback(ren)
    ren.AddObserver(vtkCommand.AnyEvent, mo1)
    # Other options to try:
    # ren.AddObserver(vtkCommand.EndEvent, mo1)
    # ren.AddObserver(vtkCommand.ResetCameraEvent, mo1)
    # ren.AddObserver(vtkCommand.KeyPressEvent, mo1)

    # Initialize and start the interaction
    iren.Initialize()
    renWin.Render()
    iren.Start()


if __name__ == '__main__':
    main()
