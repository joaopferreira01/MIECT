###############################################################################
#                                   Camera.py
###############################################################################

from vtkmodules.all import *

def main():
    # Configuração inicial do renderizador
    ren = vtkRenderer()
    ren.SetBackground(1, 1, 1)  # Cor de fundo branca

    # Configuração da janela de renderização
    renWin = vtkRenderWindow()
    renWin.AddRenderer(ren)
    renWin.SetWindowName('Camera View')
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
    cubeActor.GetProperty().SetRepresentationToWireframe()  # Wireframe mode
    ren.AddActor(cubeActor)

    # **Configuração da câmera (Nova câmera)**
    cam1 = vtkCamera()
    cam1.SetPosition(10, 10, 0)  # Posição inicial
    cam1.SetViewUp(0, 1, 0)  # Vetor de visão para cima
    ren.SetActiveCamera(cam1)  # Definir câmera no renderizador

    renWin.Render()
    print("Nova câmera definida. Pressione Enter para continuar...")
    input()

    # **Alteração para câmera padrão**
    defaultCamera = ren.GetActiveCamera()
    defaultCamera.SetPosition(10, 10, 0)  # Nova posição
    defaultCamera.SetViewUp(0, 1, 1)  # Novo vetor de visão para cima
    defaultCamera.SetParallelProjection(True)  # Ativa visão ortográfica

    renWin.Render()
    print("Câmera padrão ajustada. Pressione Enter para interagir.")
    iren.Start()


if __name__ == '__main__':
    main()
