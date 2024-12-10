###############################################################################
#                                CameraLight.py
###############################################################################

from vtkmodules.all import *

def main():
    # Configuração inicial do renderizador
    ren = vtkRenderer()
    ren.SetBackground(1, 1, 1)  # Cor de fundo branca

    # Configuração da janela de renderização
    renWin = vtkRenderWindow()
    renWin.AddRenderer(ren)
    renWin.SetWindowName('Camera and Light')
    renWin.SetSize(300, 300)  # Tamanho da janela

    # Configuração do interator para interação
    iren = vtkRenderWindowInteractor()
    iren.SetRenderWindow(renWin)

    # Criação do cubo
    cubeSource = vtkCubeSource()
    cubeMapper = vtkPolyDataMapper()
    cubeMapper.SetInputConnection(cubeSource.GetOutputPort())

    cubeActor = vtkActor()
    cubeActor.SetMapper(cubeMapper)
    ren.AddActor(cubeActor)

    # Configuração da câmera ativa e da luz
    cam1 = ren.GetActiveCamera()
    light = vtkLight()
    light.SetColor(1, 0, 0)  # Cor da luz: vermelha
    light.SetFocalPoint(cam1.GetFocalPoint())  # Ponto focal da luz
    light.SetPosition(cam1.GetPosition())  # Posição da luz (igual à da câmera)
    ren.AddLight(light)  # Adiciona a luz ao renderizador

    renWin.Render()
    print("A luz segue a posição e o ponto focal da câmera.")
    iren.Start()

if __name__ == '__main__':
    main()
